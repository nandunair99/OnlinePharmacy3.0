package com.narola.pharmacy.customer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.narola.pharmacy.utility.Constant;
import com.narola.pharmacy.utility.UtilityMethods;

public class ShowCartFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowCartFormServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			if (session != null && session.getAttribute("customerDetails") != null) {
				CustomerBean csb = (CustomerBean) session.getAttribute("customerDetails");
				CartWrapper cartWrapper = CustomerDAO.ShowCartItems(csb.getUserId());
				if (!cartWrapper.getMedicineBeans().isEmpty() || !cartWrapper.getTestBeans().isEmpty()) {
					for (CartBean crb : cartWrapper.getMedicineBeans()) {
						File dir = new File(getServletContext().getRealPath("/") + Constant.MEDICINE_IMG_FOLDER
								+ crb.getMedicineBean().getMedId());
						File[] flist = dir.listFiles();
						List<String> imagesPath = new ArrayList<>(flist.length);
						for (File file : flist) {
							imagesPath.add(request.getContextPath() + Constant.MEDICINE_IMG_FOLDER
									+ crb.getMedicineBean().getMedId() + "/" + file.getName());
						}
						System.out.println(getServletContext().getRealPath("/") + "---" + request.getContextPath());
						crb.getMedicineBean().setImagesPath(imagesPath);
					}
					request.setAttribute("mBeanList", cartWrapper.getMedicineBeans());
					for (CartBean crb : cartWrapper.getTestBeans()) {
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						final byte[] bytes = new byte[1024];
						int read = 0;
						while ((read = crb.getTestBean().getPicStream().read(bytes)) != -1) {
							bos.write(bytes, 0, read);
						}
						String encode = Base64.getEncoder().encodeToString(bos.toByteArray());
						crb.getTestBean().setBase64String(encode);
					}
					request.setAttribute("CartWrapper", cartWrapper);
				} else {
					String message = "Your cart is empty...";
					request.setAttribute("cartMessage", message);
				}
				String url = session.getAttribute("currentPage").toString();
				request.setAttribute("referrer", url);
				request.setAttribute("showCart", true);

				RequestDispatcher rd = request.getRequestDispatcher(UtilityMethods.getServletName(url));
				rd.forward(request, response);
			} else {
				response.sendRedirect("LoginForm");
			}
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while displaying cart...");
			String url = request.getHeader("referer");
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
