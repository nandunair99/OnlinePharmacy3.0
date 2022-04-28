package com.narola.pharmacy.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.PharmacyDBException;

public class RemoveTestActionServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int testId = Integer.valueOf(request.getParameter("testId"));
			TestDAO.deleteTest(testId);
			response.sendRedirect("ShowAllTest");
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while removing test...");
			RequestDispatcher rd = request.getRequestDispatcher("testmain.jsp");
			rd.forward(request, response);
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}