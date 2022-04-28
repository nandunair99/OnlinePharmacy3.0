package com.narola.pharmacy.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.PharmacyDBException;



public class ShowAllTestServlet    extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<TestBean> list;
		try {
			list = TestDAO.showAllTest();
			for(TestBean tbean:list)
			{
				ByteArrayOutputStream bos=new ByteArrayOutputStream();
				final byte[] bytes=new byte[1024];
				int read=0;
				while((read=tbean.getPicStream().read(bytes))!=-1)
				{
					bos.write(bytes,0,read);
				}
				
				String encode = Base64.getEncoder().encodeToString(bos.toByteArray());
				tbean.setBase64String(encode);
			}
			request.setAttribute("TestList", list);
			RequestDispatcher rd = request.getRequestDispatcher("testmain.jsp");
			rd.forward(request, response);
		} catch (PharmacyDBException e) {
			
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
