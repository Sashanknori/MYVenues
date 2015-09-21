package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the CUSTOMER_IDENTIFIER database table.
 * 
 */
@Embeddable
public class CustomerIdentifierPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ID", unique=true, nullable=false, length=15)
	private String customerId;

	@Column(name="CUSTOMER_TYPE", unique=true, nullable=false, length=5)
	private String customerType;

	public CustomerIdentifierPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof CustomerIdentifierPK)) {
			return false;
		}
		CustomerIdentifierPK castOther = (CustomerIdentifierPK)other;
		return 
			this.customerId.equals(castOther.customerId)
			&& this.customerType.equals(castOther.customerType);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId.hashCode();
		hash = hash * prime + this.customerType.hashCode();
		
		return hash;
	}
}