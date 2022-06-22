package com.narola.pharmacy.category;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.narola.pharmacy.exception.PharmacyDBException;

public class RemoveCategoryValidationFilter implements Filter {

	public RemoveCategoryValidationFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			String catId = request.getParameter("catId");
			if (catId == null || catId.trim().isEmpty()) {
				request.setAttribute("errMsg", "");
				RequestDispatcher rd = request.getRequestDispatcher("ShowAllCategory?isError=true");
				rd.forward(request, response);
				return;
			}
			if (CategoryDAO.isCategoryUsed(Integer.valueOf(catId))) { // checks if the category is being used by any
																		// product
				request.setAttribute("errMsg", "Category is being used by products...");
				RequestDispatcher rd = request.getRequestDispatcher("ShowAllCategory?isError=true");
				rd.forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Opps, Something wrong");
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllCategory?isError=true");
			rd.forward(request, response);
		} catch (PharmacyDBException e) {
			e.printStackTrace();
			request.setAttribute("errMsg", "Opps, Something wrong");
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllCategory?isError=true");
			rd.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("errMsg", "Opps, Something wrong");
			RequestDispatcher rd = request.getRequestDispatcher("ShowAllCategory?isError=true");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
