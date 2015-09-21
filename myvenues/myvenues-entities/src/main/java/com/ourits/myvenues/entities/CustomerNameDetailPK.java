package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUSTOMER_NAME_DETAILS database table.
 * 
 */
@Embeddable
public class CustomerNameDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ID", insertable=false, updatable=false, unique=true, nullable=false, length=15)
	private String customerId;

	@Column(name="CUSTOMER_NAME_REF_NUM", unique=true, nullable=false)
	private int customerNameRefNum;

	@Column(name="CUSTOMER_TYPE", insertable=false, updatable=false, unique=true, nullable=false, length=5)
	private String customerType;

	public CustomerNameDetailPK() {
	}
	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCustomerNameRefNum() {
		return this.customerNameRefNum;
	}
	public void setCustomerNameRefNum(int customerNameRefNum) {
		this.customerNameRefNum = customerNameRefNum;
	}
	public String getCustomerType() {
		return this.customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerNameDetailPK)) {
			return false;
		}
		CustomerNameDetailPK castOther = (CustomerNameDetailPK)other;
		return 
			this.customerId.equals(castOther.customerId)
			&& (this.customerNameRefNum == castOther.customerNameRefNum)
			&& this.customerType.equals(castOther.customerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId.hashCode();
		hash = hash * prime + this.customerNameRefNum;
		hash = hash * prime + this.customerType.hashCode();
		
		return hash;
	}
}