package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUSTOMER_EMAIL database table.
 * 
 */
@Embeddable
public class CustomerEmailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ID", insertable=false, updatable=false, unique=true, nullable=false, length=15)
	private String customerId;

	@Column(name="CUSTOMER_EMAIL_REF_NUM", unique=true, nullable=false)
	private int customerEmailRefNum;

	@Column(name="CUSTOMER_TYPE", insertable=false, updatable=false, unique=true, nullable=false, length=5)
	private String customerType;

	public CustomerEmailPK() {
	}
	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCustomerEmailRefNum() {
		return this.customerEmailRefNum;
	}
	public void setCustomerEmailRefNum(int customerEmailRefNum) {
		this.customerEmailRefNum = customerEmailRefNum;
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
		if (!(other instanceof CustomerEmailPK)) {
			return false;
		}
		CustomerEmailPK castOther = (CustomerEmailPK)other;
		return 
			this.customerId.equals(castOther.customerId)
			&& (this.customerEmailRefNum == castOther.customerEmailRefNum)
			&& this.customerType.equals(castOther.customerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId.hashCode();
		hash = hash * prime + this.customerEmailRefNum;
		hash = hash * prime + this.customerType.hashCode();
		
		return hash;
	}
}