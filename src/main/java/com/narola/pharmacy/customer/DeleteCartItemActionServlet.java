package com.narola.pharmacy.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.PharmacyDBException;

public class DeleteCartItemActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteCartItemActionServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Integer cartId = Integer.valueOf(request.getParameter("cartId"));
			CustomerDAO.deleteCartItem(cartId);
			
		} catch (PharmacyDBException e) {
			request.setAttribute("errMsg", "Error occured while deleting from cart ...");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCartForm");
			rd.forward(request, response);
			return;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
