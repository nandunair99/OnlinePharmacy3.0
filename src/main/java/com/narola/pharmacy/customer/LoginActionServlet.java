package com.narola.pharmacy.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.narola.pharmacy.PharmacyDBException;

/**
 * Servlet implementation class LoginActionServlet
 */
public class LoginActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginActionServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		try {
			String contactNo=request.getParameter("contactNotxt");
			String password=request.getParameter("passwordtxt");
			if(CustomerDAO.customerLogin(contactNo, password))
			{
				HttpSession session=request.getSession();
				CustomerBean customerBean=CustomerDAO.getCustomerByContact(contactNo);
				session.setAttribute("customerDetails",customerBean);
				String url="ShowCustomerHome";
				if(session.getAttribute("currentPage")!=null) {
					url=session.getAttribute("currentPage").toString();
				}
				System.out.println("prev of loginpage: "+url);
				
				
				response.sendRedirect(url);
				
			}		
			else
			{
				request.setAttribute("errMsg", "Invalid credentials...");
				RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
				rs.forward(request, response);
			}
				
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Something went wrong while loging in...");
			RequestDispatcher rs=request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
