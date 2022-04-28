package com.narola.pharmacy.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.narola.pharmacy.PharmacyDBException;
import com.narola.pharmacy.utility.UtilityMethods;


public class ShowCheckoutFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ShowCheckoutFormServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session=request.getSession(false);
			if (session != null && session.getAttribute("customerDetails") != null) {
			OrderBean orderBean= CustomerDAO.getOrderDetails(Integer.valueOf(request.getParameter("orderId")) );
			
			orderBean.setCustomerBean((CustomerBean)session.getAttribute("customerDetails"));
			orderBean.setOrderId(Integer.valueOf(request.getParameter("orderId")) );
			request.setAttribute("OrderBean", orderBean);
			request.setAttribute("callBackUrl", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/ValidateCustomerPayment?orderId="+Integer.valueOf(request.getParameter("orderId")));
			RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
			rd.forward(request, response);
			}
			else {
				response.sendRedirect("LoginForm");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while showing checkout page");
			
			RequestDispatcher rd = request.getRequestDispatcher(UtilityMethods.getServletName(request.getHeader("referer")));
			rd.forward(request, response);
			return;
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while showing checkout page");
			RequestDispatcher rd = request.getRequestDispatcher(UtilityMethods.getServletName(request.getHeader("referer")));
			rd.forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
