package com.narola.pharmacy.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.exception.PharmacyDBException;

/**
 * Servlet implementation class UpdateCartQuantityAction
 */
public class UpdateCartQuantityActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateCartQuantityActionServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			int cartId=Integer.parseInt(request.getParameter("cartId")) ;
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			System.out.println(cartId+" "+quantity);
			CustomerDAO.updateCartQuantity(cartId, quantity);
		} catch (PharmacyDBException e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
