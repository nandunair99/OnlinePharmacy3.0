package com.narola.pharmacy.customer;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.exception.PharmacyDBException;

public class RegisterActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RegisterActionServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			CustomerBean cb=new CustomerBean();
			cb.setFirstName(request.getParameter("fnametxt"));
			cb.setLastName(request.getParameter("lnametxt"));
			cb.setContactNo(request.getParameter("contactNotxt"));
			cb.setDob(LocalDate.parse(request.getParameter("dobtxt")));
			cb.setGender(request.getParameter("gendertxt"));
			cb.setAddress(request.getParameter("addresstxt"));
			cb.setEmailId(request.getParameter("mailtxt"));
			cb.setPassword(request.getParameter("passwordtxt"));
			CustomerDAO.insertCustomer(cb);
			response.sendRedirect("LoginForm");
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Something went Wrong...");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
