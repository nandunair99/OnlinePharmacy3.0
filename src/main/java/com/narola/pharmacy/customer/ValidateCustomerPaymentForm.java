package com.narola.pharmacy.customer;

import java.io.IOException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.narola.pharmacy.exception.PharmacyDBException;
import com.narola.pharmacy.utility.Constant;

public class ValidateCustomerPaymentForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateCustomerPaymentForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		Integer orderId = Integer.valueOf(request.getParameter("orderId"));
		String razorpayOrderId = request.getParameter("razorpay_order_id");
		String razorpayPaymentId = request.getParameter("razorpay_payment_id");
		String razorpaySignature = request.getParameter("razorpay_signature");
		String error = request.getParameter("error[description]");
		Map<String,Object> errorMap=objectMapper.readValue(request.getParameter("error"), new TypeReference<HashMap<String,Object>>() {
		});
		System.out.println(errorMap.get("error"));
		
		System.out.println(request.getParameter("error[description]"));
		System.out.println(request.getParameter("error"));

		RequestDispatcher rd = request.getRequestDispatcher("ShowCustomerHome");

		try {

			if (razorpayOrderId != null && razorpayPaymentId != null && razorpaySignature != null) {
				if (Signature
						.calculateRFC2104HMAC(razorpayOrderId + "|" + razorpayPaymentId, Constant.RAZORPAY_KEY_SECRET)
						.equals(razorpaySignature)) {
					CustomerDAO.updateTransactionStatus(Constant.TRNS_STATUS_SUCCESS, null, null, orderId);

					request.setAttribute("ShowOrderSuccess", true);
					rd.forward(request, response);
					return;
				}
			} else if (razorpayOrderId == null && razorpayPaymentId == null && razorpaySignature == null
					&& error == null) {
				error = "Customer cancelled the payment process...";

				CustomerDAO.updateTransactionStatus(Constant.TRNS_STATUS_FAIL, error, error, orderId);
			} else {
				CustomerDAO.updateTransactionStatus(Constant.TRNS_STATUS_FAIL, error,
						objectMapper.writeValueAsString(request.getParameter("error")), orderId);
			}

			CustomerDAO.updateOrderStatus(Constant.ORDER_STATUS_CANCELLED, orderId);

			request.setAttribute("ShowOrderSuccess", false);
			request.setAttribute("paymentErrorMsg", error);
			rd.forward(request, response);

		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (PharmacyDBException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
