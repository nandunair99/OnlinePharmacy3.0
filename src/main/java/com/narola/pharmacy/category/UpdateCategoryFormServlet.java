package com.narola.pharmacy.category;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.exception.PharmacyDBException;

public class UpdateCategoryFormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryBean cb;
		try {
			int catId = Integer.valueOf(request.getParameter("catId"));
			cb = CategoryDAO.getCategoryById(catId);
			request.setAttribute("CategoryBean", cb);
			RequestDispatcher rd = request.getRequestDispatcher("category-update-form.jsp");
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
