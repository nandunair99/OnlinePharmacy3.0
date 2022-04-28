package com.narola.pharmacy.utility;

public class UtilityMethods {

	public static String getServletName(String url)
	{
		url = url + " ";
		String[] urls = url.split("/");
		return urls[urls.length - 1].trim();
	}
}
