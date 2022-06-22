package com.narola.pharmacy.customer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.narola.pharmacy.exception.PharmacyDBException;
import com.narola.pharmacy.paymentgateway.OrderRequestEntity;
import com.narola.pharmacy.paymentgateway.RazerPaymentgateway;

public class PlaceOrderActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PlaceOrderActionServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			Integer orderId = null;

			OrderBean orderBean = new OrderBean();
			orderBean.setCartIds(request.getParameterValues("cartIdtxt"));
			orderBean.setTotalAmount(Double.valueOf(request.getParameter("totalAmounttxt")));
			orderBean.setCustomerBean((CustomerBean) session.getAttribute("customerDetails"));
			if (request.getParameter("medIdtxt") != null) {
				orderBean.setMedId(Integer.valueOf(request.getParameter("medIdtxt")));
			} else if (request.getParameter("testIdtxt") != null) {
				orderBean.setTestId(Integer.valueOf(request.getParameter("testIdtxt")));
			}

			orderId = CustomerDAO.insertOrder(orderBean);
			if (orderId != null && orderId != -1) {

				OrderRequestEntity orderEntity = new OrderRequestEntity();
				orderEntity.setAmount(Double.valueOf(request.getParameter("totalAmounttxt")) * 100);
				RazerPaymentgateway razerPaymentgateway = new RazerPaymentgateway();
				String razorpayOrderId = razerPaymentgateway.createOrder(orderEntity, orderId);
				if (razorpayOrderId != null) {
					CustomerDAO.updateRazorpayOrderId(razorpayOrderId, orderId);
					response.sendRedirect("ShowCheckoutForm?orderId=" + orderId);
					return;
				} else {
					request.setAttribute("errMsg", "Error occured while Placing order...");
					RequestDispatcher rd = request.getRequestDispatcher("ShowCartForm");
					rd.forward(request, response);
					return;
				}

			} else if (orderId == -1) {
				request.setAttribute("errMsg", "The cart is empty...");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCartForm");
				rd.forward(request, response);
				return;
			}

		}

		catch (

		PharmacyDBException e) {

			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while Placing order...");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartForm");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
