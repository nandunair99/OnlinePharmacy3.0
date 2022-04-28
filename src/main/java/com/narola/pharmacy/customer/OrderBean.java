package com.narola.pharmacy.customer;

import java.time.LocalDate;

public class OrderBean {
	private CustomerBean customerBean=new CustomerBean();
	private Integer orderId;
	private double totalAmount;
	private String razorpayOrderId=null;
	private String[] cartIds;
	private Integer medId;
	private Integer testId;
	private CartWrapper cartWrapper;
	private String status;
	private LocalDate date;
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CartWrapper getCartWrapper() {
		return cartWrapper;
	}
	public void setCartWrapper(CartWrapper cartWrapper) {
		this.cartWrapper = cartWrapper;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getMedId() {
		return medId;
	}
	public void setMedId(Integer medId) {
		this.medId = medId;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public String[] getCartIds() {
		return cartIds;
	}
	public void setCartIds(String[] cartIds) {
		this.cartIds = cartIds;
	}
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRazorpayOrderId() {
		return razorpayOrderId;
	}
	public void setRazorpayOrderId(String razorpayOrderId) {
		this.razorpayOrderId = razorpayOrderId;
	}
	
	
}
