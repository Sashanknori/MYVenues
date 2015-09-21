package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORGANIZATION_MAPPER database table.
 * 
 */
@Embeddable
public class OrganizationMapperPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="CUSTOMER_ID", insertable=false, updatable=false, unique=true, nullable=false, length=15)
	private String customerId;

	@Column(name="CUSTOMER_TYPE", insertable=false, updatable=false, unique=true, nullable=false, length=5)
	private String customerType;

	@Column(name="ORGANIZATION_ID", unique=true, nullable=false, length=10)
	private String organizationId;

	public OrganizationMapperPK() {
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
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrganizationMapperPK)) {
			return false;
		}
		OrganizationMapperPK castOther = (OrganizationMapperPK)other;
		return 
			this.customerId.equals(castOther.customerId)
			&& this.customerType.equals(castOther.customerType)
			&& this.organizationId.equals(castOther.organizationId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.customerId.hashCode();
		hash = hash * prime + this.customerType.hashCode();
		hash = hash * prime + this.organizationId.hashCode();
		
		return hash;
	}
}