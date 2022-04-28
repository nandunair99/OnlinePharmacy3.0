package com.narola.pharmacy.category;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CategoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer catId;
	private String catName;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private Boolean popular;

	public CategoryBean() {

	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	public Boolean getPopular() {
		return popular;
	}

	public void setPopular(Boolean popular) {
		this.popular = popular;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getCatId() {
		return this.catId;
	}

	public String getCatName() {
		return this.catName;
	}

	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return this.updatedOn;
	}

	@Override
	public String toString() {
		return "CategoryBean [catId=" + catId + ", catName=" + catName + ", createdOn=" + createdOn + ", updatedOn="
				+ updatedOn + ", popular=" + popular + "]";
	}
}
