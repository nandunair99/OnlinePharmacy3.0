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

/**
 * Servlet Filter implementation class Validation1
 */
public class UpdateCategoryValidationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public UpdateCategoryValidationFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * checks if categoryName already exists and current catId doesn't return the
	 * same categoryName i.e. categoryName exists and its not of the current catId
	 * i.e. its of some other categoryId
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			String val = request.getParameter("catNametxt");
			if (val == null || val.trim().isEmpty()) { // checks if value is null or empty
				request.setAttribute("errMsg", "Please provide category name");// set error message
				RequestDispatcher rd = request.getRequestDispatcher("/updateCategoryForm?isError=true");// show in url
																										// that error
																										// occured
				rd.forward(request, response);
			} else {

				if (CategoryDAO.categoryIsExist(val) && (!val.toLowerCase().equals(
						CategoryDAO.getCategoryById(Integer.valueOf(request.getParameter("catId"))).getCatName()))) {
					request.setAttribute("errMsg", "Category already exists...");// set error message
					RequestDispatcher rd = request.getRequestDispatcher("/updateCategoryForm?isError=true");
					rd.forward(request, response);
				} else {
					request.setAttribute("errMsg", "");
					chain.doFilter(request, response);
				}
			}
		} catch (PharmacyDBException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
