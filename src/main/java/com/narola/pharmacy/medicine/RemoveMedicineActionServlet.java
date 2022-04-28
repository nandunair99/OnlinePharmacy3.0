package com.narola.pharmacy.medicine;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.narola.pharmacy.PharmacyDBException;

public class RemoveMedicineActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int medId = Integer.valueOf(request.getParameter("medId"));
			MedicineDAO.deleteMedicine(medId);
			response.sendRedirect("ShowAllMedicine");
		} catch (PharmacyDBException e) {

			e.printStackTrace();
			request.setAttribute("errMsg", "Error occured while updating");
			RequestDispatcher rd = request.getRequestDispatcher("medicinemain.jsp");
			rd.forward(request, response);
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}