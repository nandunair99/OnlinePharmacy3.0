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

public class UpdateTestActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int testId = Integer.valueOf(request.getParameter("testId"));
			
			Part image = request.getPart("picturetxt");
			String fileName = image.getSubmittedFileName();
			TestBean tb=new TestBean();
			InputStream filecontent = null;
			if (!fileName.equals(null) && !fileName.equals(""))// if medicine not updated
			{
				filecontent = image.getInputStream();
			}
			tb.setTestId(Integer.valueOf(request.getParameter("testId")));
			tb.setTestName(request.getParameter("testNametxt"));
			tb.setTestPrice(Double.valueOf(request.getParameter("testPricetxt")));
			tb.setTestDiscount(Double.valueOf(request.getParameter("testDiscounttxt")));
			tb.setTestDescription(request.getParameter("testDesctxt"));
			tb.setTestPreparation(request.getParameter("testPreparationtxt"));
			tb.setPicStream(filecontent);
			TestDAO.updateTest(testId, tb);
			response.sendRedirect("ShowAllTest");
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while Updating test...");
			RequestDispatcher rd = request.getRequestDispatcher("test-update-form.jsp");
			rd.forward(request, response);
			return;
		}

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
