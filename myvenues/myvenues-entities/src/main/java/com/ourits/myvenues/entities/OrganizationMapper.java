package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ORGANIZATION_MAPPER database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION_MAPPER")
@NamedQuery(name="OrganizationMapper.findAll", query="SELECT o FROM OrganizationMapper o")
public class OrganizationMapper implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrganizationMapperPK id;

	@Column(name="CREATE_DATE", nullable=false)
	private Timestamp createDate;

	@Column(name="LAST_MODIFIED_DATE", nullable=false)
	private Timestamp lastModifiedDate;

	@Column(name="ORGANIZATION_ADDRESS_REF_NUM", nullable=false)
	private int organizationAddressRefNum;

	@Column(name="ORGANIZATION_EMAIL_REF_NUM", nullable=false)
	private int organizationEmailRefNum;

	@Column(name="ORGANIZATION_NAME_REF_NUM", nullable=false)
	private int organizationNameRefNum;

	@Column(name="ORGANIZATION_PHONE_REF_NUMBER", nullable=false)
	private int organizationPhoneRefNumber;

	@Column(name="ORGANIZATION_SUBSCRIPTION_STATUS", nullable=false, length=1)
	private String organizationSubscriptionStatus;

	//bi-directional one-to-one association to OrganizationAvailability
	@OneToOne(mappedBy="organizationMapper")
	private OrganizationAvailability organizationAvailability;

	//bi-directional many-to-one association to CustomerIdentifier
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_TYPE", referencedColumnName="CUSTOMER_TYPE", nullable=false, insertable=false, updatable=false)
		})
	private CustomerIdentifier customerIdentifier;

	public OrganizationMapper() {
	}

	public OrganizationMapperPK getId() {
		return this.id;
	}

	public void setId(OrganizationMapperPK id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getOrganizationAddressRefNum() {
		return this.organizationAddressRefNum;
	}

	public void setOrganizationAddressRefNum(int organizationAddressRefNum) {
		this.organizationAddressRefNum = organizationAddressRefNum;
	}

	public int getOrganizationEmailRefNum() {
		return this.organizationEmailRefNum;
	}

	public void setOrganizationEmailRefNum(int organizationEmailRefNum) {
		this.organizationEmailRefNum = organizationEmailRefNum;
	}

	public int getOrganizationNameRefNum() {
		return this.organizationNameRefNum;
	}

	public void setOrganizationNameRefNum(int organizationNameRefNum) {
		this.organizationNameRefNum = organizationNameRefNum;
	}

	public int getOrganizationPhoneRefNumber() {
		return this.organizationPhoneRefNumber;
	}

	public void setOrganizationPhoneRefNumber(int organizationPhoneRefNumber) {
		this.organizationPhoneRefNumber = organizationPhoneRefNumber;
	}

	public String getOrganizationSubscriptionStatus() {
		return this.organizationSubscriptionStatus;
	}

	public void setOrganizationSubscriptionStatus(String organizationSubscriptionStatus) {
		this.organizationSubscriptionStatus = organizationSubscriptionStatus;
	}

	public OrganizationAvailability getOrganizationAvailability() {
		return this.organizationAvailability;
	}

	public void setOrganizationAvailability(OrganizationAvailability organizationAvailability) {
		this.organizationAvailability = organizationAvailability;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return this.customerIdentifier;
	}

	public void setCustomerIdentifier(CustomerIdentifier customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}