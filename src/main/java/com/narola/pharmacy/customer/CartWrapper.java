package com.narola.pharmacy.customer;

import java.util.List;

public class CartWrapper {

	private List<CartBean> medicineBeans;
	private List<CartBean> testBeans;

	public List<CartBean> getMedicineBeans() {
		return medicineBeans;
	}

	public void setMedicineBeans(List<CartBean> medicineBeans) {
		this.medicineBeans = medicineBeans;
	}

	public List<CartBean> getTestBeans() {
		return testBeans;
	}

	public void setTestBeans(List<CartBean> testBeans) {
		this.testBeans = testBeans;
	}

	
	public int getTotalItems() {
		int size = 0;
		if (this.medicineBeans != null) {
			size = size + this.medicineBeans.size();
		}
		if (this.testBeans != null) {
			size = size + this.testBeans.size();
		}
		return size;
	}

	public double getTotalAmount() {
		double amount = 0;
		if (!this.medicineBeans.isEmpty()) {
			for (CartBean cartBean : this.medicineBeans) {
				amount = amount + cartBean.getMedicineBean().getMedDiscountedPrice() * cartBean.getQuantity();
			}
		}
		if (!this.testBeans.isEmpty()) {
			for (CartBean cartBean : this.testBeans) {
				amount = amount + cartBean.getTestBean().getTestDiscountedPrice() * cartBean.getQuantity();
			}
		}
		return amount;
	}
	
	public double getTotalAmountWithoutDiscount() {
		double amount = 0;
		if (!this.medicineBeans.isEmpty()) {
			for (CartBean cartBean : this.medicineBeans) {
				amount = amount + cartBean.getMedicineBean().getMedPrice() * cartBean.getQuantity();
			}
		}
		if (!this.testBeans.isEmpty()) {
			for (CartBean cartBean : this.testBeans) {
				amount = amount + cartBean.getTestBean().getTestPrice() * cartBean.getQuantity();
			}
		}
		return amount;
	}

}
