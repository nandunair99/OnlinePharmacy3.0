package com.narola.pharmacy.customer;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class LoginValidationFilter
 */
public class LoginValidationFilter implements Filter {

	public LoginValidationFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		CustomerBean cb=new CustomerBean();
	
		String contact = request.getParameter("contactNotxt");
		String password = request.getParameter("passwordtxt");
		cb.setContactNo(contact);
		cb.setPassword(password);
		if (contact.equals(null) || contact.isEmpty() || password.equals(null) || password.isEmpty()) {
			request.setAttribute("errMsg", "Please fill Username and password...");
			RequestDispatcher rd = request.getRequestDispatcher("LoginForm");
			request.setAttribute("CustomerBean", cb);
			rd.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
