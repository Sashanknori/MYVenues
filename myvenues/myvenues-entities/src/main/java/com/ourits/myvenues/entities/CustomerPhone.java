package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CUSTOMER_PHONE database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_PHONE")
@NamedQuery(name="CustomerPhone.findAll", query="SELECT c FROM CustomerPhone c")
public class CustomerPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerPhonePK id;

	@Column(name="COUNTRY_CODE", nullable=false, length=3)
	private String countryCode;

	@Column(name="CREATE_DATE", nullable=false)
	private Timestamp createDate;

	@Column(name="PHONE_NUMBER", nullable=false, length=1)
	private String phoneNumber;

	@Column(name="PHONE_TYPE", nullable=false, length=1)
	private String phoneType;

	@Column(name="PREFERRED_PHONE_FLAG", nullable=false, length=1)
	private String preferredPhoneFlag;

	//bi-directional many-to-one association to CustomerIdentifier
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_TYPE", referencedColumnName="CUSTOMER_TYPE", nullable=false, insertable=false, updatable=false)
		})
	private CustomerIdentifier customerIdentifier;

	public CustomerPhone() {
	}

	public CustomerPhonePK getId() {
		return this.id;
	}

	public void setId(CustomerPhonePK id) {
		this.id = id;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return this.phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPreferredPhoneFlag() {
		return this.preferredPhoneFlag;
	}

	public void setPreferredPhoneFlag(String preferredPhoneFlag) {
		this.preferredPhoneFlag = preferredPhoneFlag;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return this.customerIdentifier;
	}

	public void setCustomerIdentifier(CustomerIdentifier customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}