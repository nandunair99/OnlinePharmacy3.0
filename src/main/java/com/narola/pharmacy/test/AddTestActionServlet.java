package com.narola.pharmacy.test;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.narola.pharmacy.PharmacyDBException;

public class AddTestActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try
		{
			Part image = request.getPart("picturetxt");
			InputStream filecontent = image.getInputStream();
			
			TestBean tb=new TestBean();
			tb.setTestName(request.getParameter("testNametxt"));
			tb.setTestPrice(Double.valueOf(request.getParameter("testPricetxt")));
			tb.setTestDiscount(Double.valueOf(request.getParameter("testDiscounttxt")));
			tb.setTestDescription(request.getParameter("testDesctxt"));
			tb.setTestPreparation(request.getParameter("testPreparationtxt"));
			tb.setPicStream(filecontent);
			
			TestDAO.InsertTest(tb);// inserting with random name
			

			response.sendRedirect("ShowAllTest");
		}
		catch(PharmacyDBException e)
		{
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while Adding test...");
			RequestDispatcher rd = request.getRequestDispatcher("addtest.jsp");
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
