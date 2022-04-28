package com.narola.pharmacy.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.PharmacyDBException;

public class ManagePopularCategoryActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagePopularCategoryActionServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Integer catId = Integer.valueOf(request.getParameter("catId"));
			String action = request.getParameter("action");
			CategoryDAO.updatePopularity(catId, action);
		} catch (PharmacyDBException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
