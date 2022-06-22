package com.narola.pharmacy.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.exception.PharmacyDBException;
import com.narola.pharmacy.customer.CustomerDAO;
import com.narola.pharmacy.customer.OrderBean;


public class ShowAllOrdersFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ShowAllOrdersFormServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<OrderBean> orderBeans=new ArrayList<>();
			orderBeans=CustomerDAO.getAllOrders();
			request.setAttribute("OrderBeans", orderBeans);
			RequestDispatcher rd=request.getRequestDispatcher("manageorderstatus.jsp");
			rd.forward(request, response);
			
			
		} catch (PharmacyDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
