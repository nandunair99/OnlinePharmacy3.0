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

import com.narola.pharmacy.PharmacyDBException;
import com.narola.pharmacy.utility.Constant;
import com.narola.pharmacy.utility.UtilityMethods;

public class ShowPastOrdersFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowPastOrdersFormServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session =request.getSession(false);
			if (session != null && session.getAttribute("customerDetails") != null) {
				List<OrderBean> pastOrders=CustomerDAO.showPastOrders(((CustomerBean)session.getAttribute("customerDetails")).getUserId());
				for(OrderBean orderBean:pastOrders)
				{
					//if (!cartWrapper.getMedicineBeans().isEmpty() || !cartWrapper.getTestBeans().isEmpty()) {
						for (CartBean crb : orderBean.getCartWrapper().getMedicineBeans()) {
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
						request.setAttribute("mBeanList", orderBean.getCartWrapper().getMedicineBeans());
						for (CartBean crb : orderBean.getCartWrapper().getTestBeans()) {
							ByteArrayOutputStream bos = new ByteArrayOutputStream();
							final byte[] bytes = new byte[1024];
							int read = 0;
							while ((read = crb.getTestBean().getPicStream().read(bytes)) != -1) {
								bos.write(bytes, 0, read);
							}
							String encode = Base64.getEncoder().encodeToString(bos.toByteArray());
							crb.getTestBean().setBase64String(encode);
						}
						
						/*
						 * } else { String message = "Your cart is empty...";
						 * request.setAttribute("cartMessage", message); }
						 */
				}
				request.setAttribute("PastOrders", pastOrders);
				String url = session.getAttribute("currentPage").toString();
				request.setAttribute("referrer", url);
				request.setAttribute("showPastOrders", true);

				RequestDispatcher rd = request.getRequestDispatcher(UtilityMethods.getServletName(url));
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("LoginForm");
			}
			
			

		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while displaying Past Orders...");
			String url = request.getHeader("referer");
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
