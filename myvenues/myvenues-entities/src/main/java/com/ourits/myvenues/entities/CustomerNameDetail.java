package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CUSTOMER_NAME_DETAILS database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_NAME_DETAILS")
@NamedQuery(name="CustomerNameDetail.findAll", query="SELECT c FROM CustomerNameDetail c")
public class CustomerNameDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerNameDetailPK id;

	@Column(name="CREATE_DATE", nullable=false)
	private Timestamp createDate;

	@Column(name="FIRST_NAME", nullable=false, length=50)
	private String firstName;

	@Column(name="LAST_NAME", length=50)
	private String lastName;

	@Column(name="MIDDLE_NAME", length=40)
	private String middleName;

	@Column(name="PREFERRED_NAME_FLAG", nullable=false, length=1)
	private String preferredNameFlag;

	@Column(name="SUFFIX", length=20)
	private String suffix;

	//bi-directional many-to-one association to CustomerIdentifier
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_TYPE", referencedColumnName="CUSTOMER_TYPE", nullable=false, insertable=false, updatable=false)
		})
	private CustomerIdentifier customerIdentifier;

	public CustomerNameDetail() {
	}

	public CustomerNameDetailPK getId() {
		return this.id;
	}

	public void setId(CustomerNameDetailPK id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPreferredNameFlag() {
		return this.preferredNameFlag;
	}

	public void setPreferredNameFlag(String preferredNameFlag) {
		this.preferredNameFlag = preferredNameFlag;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return this.customerIdentifier;
	}

	public void setCustomerIdentifier(CustomerIdentifier customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}