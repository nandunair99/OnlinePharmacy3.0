package com.narola.pharmacy.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.exception.PharmacyDBException;

public class AddCategoryActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String catName = request.getParameter("catNametxt");
		try {
			int catId = CategoryDAO.InsertCategory(catName); // inserts a category
			System.out.println(catId);
			response.sendRedirect("ShowAllCategory");
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while inserting...");
			RequestDispatcher rd = request.getRequestDispatcher("addcategory.jsp");
			rd.forward(request, response);
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
