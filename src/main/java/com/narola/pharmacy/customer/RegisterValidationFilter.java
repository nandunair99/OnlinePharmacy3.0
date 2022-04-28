package com.narola.pharmacy.customer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.narola.pharmacy.PharmacyDBException;

/**
 * Servlet Filter implementation class RegisterValidationFilter
 */
public class RegisterValidationFilter implements Filter {

    public RegisterValidationFilter() {
    }

	
	public void destroy() {
		
	}

	public static boolean isNumber(String number)
	{
		boolean status=true;
		for(Character c:number.toCharArray())
		{
			if(!Character.isDigit(c))
			{
				status=false;
			}
		}return status;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try
		{
			System.out.println("im in reg filter");
		String firstname=request.getParameter("fnametxt");
		String lastname=request.getParameter("lnametxt");
		String contact=request.getParameter("contactNotxt");
		String dob=request.getParameter("dobtxt");
		String address=request.getParameter("addresstxt");
		String email=request.getParameter("mailtxt");	
		String password=request.getParameter("passwordtxt");
		String cPassword=request.getParameter("cpasswordtxt");
		
		LocalDate dobdate=null;
		CustomerBean cb=new CustomerBean();
		cb.setFirstName(firstname);
		cb.setLastName(lastname);
		cb.setContactNo(contact);
		if(!dob.equals(null)&&!dob.isEmpty())
		{
			dobdate=LocalDate.parse(dob,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		
		cb.setDob(dobdate);
		cb.setAddress(address);
		cb.setEmailId(email);
		cb.setPassword(password);
		if(!isNumber(contact)||contact.length()<10)
		{
			request.setAttribute("errMsg", "Please enter valid Contact number...");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForm");
			request.setAttribute("CustomerBean", cb);
			rd.forward(request, response);
		}
		
		else if(CustomerDAO.getCustomerByContact(contact).getContactNo()!=null)
		{
			request.setAttribute("errMsg", "Contact no. already registered");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForm");
			request.setAttribute("CustomerBean", cb);
			rd.forward(request, response);
		}
		else if(!password.equals(cPassword))
		{
			request.setAttribute("errMsg", "Password and confirm password fields do not match");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForm");
			request.setAttribute("CustomerBean", cb);
			rd.forward(request, response);
		}
		else if(firstname.equals(null)||firstname.isEmpty() || lastname.equals(null) || lastname.isEmpty() || contact.equals(null) || contact.isEmpty() || dob.equals(null) || dob.isEmpty()||  address.equals(null) || address.isEmpty() || email.equals(null) || email.isEmpty() || password.equals(null) || password.isEmpty() || cPassword.equals(null) || cPassword.isEmpty())
		{
			request.setAttribute("errMsg", "Please fill all the fields...");
			RequestDispatcher rd = request.getRequestDispatcher("RegisterForm");
			request.setAttribute("CustomerBean", cb);
			rd.forward(request, response);
			
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		
		}
		catch( PharmacyDBException e)
		{
			e.printStackTrace();
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
