package com.narola.pharmacy.exception;

public class PharmacyDBException extends Exception {

	private static final long serialVersionUID = 1L;

	public PharmacyDBException(String msg) {
		super(msg);
	}
	
	public PharmacyDBException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	

}
