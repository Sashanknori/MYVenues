package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUSTOMER_PHONE database table.
 * 
 */
@Embeddable
public class CustomerPhonePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ID", insertable=false, updatable=false, unique=true, nullable=false, length=15)
	private String customerId;

	@Column(name="CUSTOMER_TYPE", insertable=false, updatable=false, unique=true, nullable=false, length=5)
	private String customerType;

	@Column(name="CUSTOMER_PHONE_REF_NUM", unique=true, nullable=false)
	private int customerPhoneRefNum;

	public CustomerPhonePK() {
	}
	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerType() {
		return this.customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public int getCustomerPhoneRefNum() {
		return this.customerPhoneRefNum;
	}
	public void setCustomerPhoneRefNum(int customerPhoneRefNum) {
		this.customerPhoneRefNum = customerPhoneRefNum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerPhonePK)) {
			return false;
		}
		CustomerPhonePK castOther = (CustomerPhonePK)other;
		return 
			this.customerId.equals(castOther.customerId)
			&& this.customerType.equals(castOther.customerType)
			&& (this.customerPhoneRefNum == castOther.customerPhoneRefNum);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId.hashCode();
		hash = hash * prime + this.customerType.hashCode();
		hash = hash * prime + this.customerPhoneRefNum;
		
		return hash;
	}
}