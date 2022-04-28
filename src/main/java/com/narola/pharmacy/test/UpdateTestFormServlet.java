package com.narola.pharmacy.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.PharmacyDBException;

public class UpdateTestFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TestBean tb;
		try {
			int testId = Integer.valueOf(request.getParameter("testId"));
			tb = TestDAO.getTestById(testId);
			
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			final byte[] bytes=new byte[1024];
			int read=0;
			while((read=tb.getPicStream().read(bytes))!=-1)
			{
				bos.write(bytes,0,read);
			}
			String encode = Base64.getEncoder().encodeToString((byte[]) bos.toByteArray());
			tb.setBase64String(encode);
			request.setAttribute("TestBean", tb);
			RequestDispatcher rd = request.getRequestDispatcher("test-update-form.jsp");
			rd.forward(request, response);
		} catch (PharmacyDBException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}