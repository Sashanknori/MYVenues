package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUSTOMER_ADDRESS database table.
 * 
 */
@Embeddable
public class CustomerAddressPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ID", insertable=false, updatable=false, unique=true, nullable=false, length=15)
	private String customerId;

	@Column(name="CUSTOMER_ADDRESS_REF_NUM", unique=true, nullable=false)
	private int customerAddressRefNum;

	@Column(name="CUSTOMER_TYPE", insertable=false, updatable=false, unique=true, nullable=false, length=5)
	private String customerType;

	public CustomerAddressPK() {
	}
	public String getCustomerId() {
		return this.customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCustomerAddressRefNum() {
		return this.customerAddressRefNum;
	}
	public void setCustomerAddressRefNum(int customerAddressRefNum) {
		this.customerAddressRefNum = customerAddressRefNum;
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
		if (!(other instanceof CustomerAddressPK)) {
			return false;
		}
		CustomerAddressPK castOther = (CustomerAddressPK)other;
		return 
			this.customerId.equals(castOther.customerId)
			&& (this.customerAddressRefNum == castOther.customerAddressRefNum)
			&& this.customerType.equals(castOther.customerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId.hashCode();
		hash = hash * prime + this.customerAddressRefNum;
		hash = hash * prime + this.customerType.hashCode();
		
		return hash;
	}
}