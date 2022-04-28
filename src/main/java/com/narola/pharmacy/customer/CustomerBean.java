package com.narola.pharmacy.customer;

import java.io.InputStream;
import java.time.LocalDate;

public class CustomerBean {

	private int userId;
	private String firstName;
	private String lastName;
	private String contactNo;
	private LocalDate dob;
	private String gender;
	private String address;
	private String emailId;
	private String password;
	private boolean isActive;
	private InputStream picStream;

	public InputStream getPicStream() {
		return picStream;
	}

	public void setPicStream(InputStream picStream) {
		this.picStream = picStream;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "CustomerBean [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo="
				+ contactNo + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", emailId=" + emailId
				+ ", password=" + password + ", isActive=" + isActive + "]";
	}

}
