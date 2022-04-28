package com.narola.pharmacy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.customer.CustomerDAO;


public class UpdateOrderStatusActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateOrderStatusActionServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer orderId=Integer.valueOf(request.getParameter("orderId"));
			String status=request.getParameter("status");
			CustomerDAO.updateOrderStatus(status, orderId);
		} catch (PharmacyDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
