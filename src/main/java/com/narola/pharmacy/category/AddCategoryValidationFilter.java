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
 * Servlet Filter implementation class Validation2
 */
public class AddCategoryValidationFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AddCategoryValidationFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		try {
			System.out.println("In AddCategoryValidationFilter...");

			String val = request.getParameter("catNametxt");

			if (val.equals("") || val.equals(null) || val.isEmpty()) // checks if category is null or empty
			{
				request.setAttribute("errMsg", "Category Name cannot be empty while Inserting...");
				RequestDispatcher rd = request.getRequestDispatcher("AddCategoryForm?isError=true");
				rd.forward(request, response);
			} else {
				String catName = request.getParameter("catNametxt");
				if (CategoryDAO.categoryIsExist(catName)) // checks if category already exists
				{
					request.setAttribute("errMsg", "Category Already exists...");
					RequestDispatcher rd = request.getRequestDispatcher("AddCategoryForm?isError=true");
					rd.forward(request, response);
				} else // the category doesn't exist
				{
					System.out.println("Category does not Exist");

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
