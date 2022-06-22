package com.narola.pharmacy.category;

import javax.servlet.*;
import javax.servlet.http.*;

import com.narola.pharmacy.exception.PharmacyDBException;

import java.io.*;
import java.util.List;

public class ShowAllCategoryServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<CategoryBean> list = CategoryDAO.showAllCategory();// list of all categories
			request.setAttribute("CategoryList", list);
			RequestDispatcher rd2 = request.getRequestDispatcher("categorymain.jsp");
			rd2.forward(request, response);
		} catch (PharmacyDBException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
