package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the CUSTOMER_IDENTIFIER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_IDENTIFIER")
@NamedQuery(name="CustomerIdentifier.findAll", query="SELECT c FROM CustomerIdentifier c")
public class CustomerIdentifier implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerIdentifierPK id;

	@Column(name="CUSTOMER_ADDRESS_REF_NUM", nullable=false)
	private int customerAddressRefNum;

	@Column(name="CUSTOMER_CREATE_DATE", nullable=false)
	private Timestamp customerCreateDate;

	@Column(name="CUSTOMER_EMAIL_REF_NUM", nullable=false)
	private int customerEmailRefNum;

	@Column(name="CUSTOMER_NAME_REF_NUM", nullable=false)
	private int customerNameRefNum;

	@Column(name="CUSTOMER_PHONE_REF_NUM", nullable=false)
	private int customerPhoneRefNum;

	@Column(name="CUSTOMER_SUBSCRIPTION_STATUS", nullable=false, length=1)
	private String customerSubscriptionStatus;

	@Column(name="LAST_MODIFIED_DATE", nullable=false)
	private Timestamp lastModifiedDate;

	//bi-directional many-to-one association to CustomerAddress
	@OneToMany(mappedBy="customerIdentifier")
	private List<CustomerAddress> customerAddresses;

	//bi-directional many-to-one association to CustomerEmail
	@OneToMany(mappedBy="customerIdentifier")
	private List<CustomerEmail> customerEmails;

	//bi-directional many-to-one association to CustomerNameDetail
	@OneToMany(mappedBy="customerIdentifier")
	private List<CustomerNameDetail> customerNameDetails;

	//bi-directional many-to-one association to CustomerPhone
	@OneToMany(mappedBy="customerIdentifier")
	private List<CustomerPhone> customerPhones;

	//bi-directional many-to-one association to OrganizationMapper
	@OneToMany(mappedBy="customerIdentifier")
	private List<OrganizationMapper> organizationMappers;

	public CustomerIdentifier() {
	}

	public CustomerIdentifierPK getId() {
		return this.id;
	}

	public void setId(CustomerIdentifierPK id) {
		this.id = id;
	}

	public int getCustomerAddressRefNum() {
		return this.customerAddressRefNum;
	}

	public void setCustomerAddressRefNum(int customerAddressRefNum) {
		this.customerAddressRefNum = customerAddressRefNum;
	}

	public Timestamp getCustomerCreateDate() {
		return this.customerCreateDate;
	}

	public void setCustomerCreateDate(Timestamp customerCreateDate) {
		this.customerCreateDate = customerCreateDate;
	}

	public int getCustomerEmailRefNum() {
		return this.customerEmailRefNum;
	}

	public void setCustomerEmailRefNum(int customerEmailRefNum) {
		this.customerEmailRefNum = customerEmailRefNum;
	}

	public int getCustomerNameRefNum() {
		return this.customerNameRefNum;
	}

	public void setCustomerNameRefNum(int customerNameRefNum) {
		this.customerNameRefNum = customerNameRefNum;
	}

	public int getCustomerPhoneRefNum() {
		return this.customerPhoneRefNum;
	}

	public void setCustomerPhoneRefNum(int customerPhoneRefNum) {
		this.customerPhoneRefNum = customerPhoneRefNum;
	}

	public String getCustomerSubscriptionStatus() {
		return this.customerSubscriptionStatus;
	}

	public void setCustomerSubscriptionStatus(String customerSubscriptionStatus) {
		this.customerSubscriptionStatus = customerSubscriptionStatus;
	}

	public Timestamp getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public List<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public CustomerAddress addCustomerAddress(CustomerAddress customerAddress) {
		getCustomerAddresses().add(customerAddress);
		customerAddress.setCustomerIdentifier(this);

		return customerAddress;
	}

	public CustomerAddress removeCustomerAddress(CustomerAddress customerAddress) {
		getCustomerAddresses().remove(customerAddress);
		customerAddress.setCustomerIdentifier(null);

		return customerAddress;
	}

	public List<CustomerEmail> getCustomerEmails() {
		return this.customerEmails;
	}

	public void setCustomerEmails(List<CustomerEmail> customerEmails) {
		this.customerEmails = customerEmails;
	}

	public CustomerEmail addCustomerEmail(CustomerEmail customerEmail) {
		getCustomerEmails().add(customerEmail);
		customerEmail.setCustomerIdentifier(this);

		return customerEmail;
	}

	public CustomerEmail removeCustomerEmail(CustomerEmail customerEmail) {
		getCustomerEmails().remove(customerEmail);
		customerEmail.setCustomerIdentifier(null);

		return customerEmail;
	}

	public List<CustomerNameDetail> getCustomerNameDetails() {
		return this.customerNameDetails;
	}

	public void setCustomerNameDetails(List<CustomerNameDetail> customerNameDetails) {
		this.customerNameDetails = customerNameDetails;
	}

	public CustomerNameDetail addCustomerNameDetail(CustomerNameDetail customerNameDetail) {
		getCustomerNameDetails().add(customerNameDetail);
		customerNameDetail.setCustomerIdentifier(this);

		return customerNameDetail;
	}

	public CustomerNameDetail removeCustomerNameDetail(CustomerNameDetail customerNameDetail) {
		getCustomerNameDetails().remove(customerNameDetail);
		customerNameDetail.setCustomerIdentifier(null);

		return customerNameDetail;
	}

	public List<CustomerPhone> getCustomerPhones() {
		return this.customerPhones;
	}

	public void setCustomerPhones(List<CustomerPhone> customerPhones) {
		this.customerPhones = customerPhones;
	}

	public CustomerPhone addCustomerPhone(CustomerPhone customerPhone) {
		getCustomerPhones().add(customerPhone);
		customerPhone.setCustomerIdentifier(this);

		return customerPhone;
	}

	public CustomerPhone removeCustomerPhone(CustomerPhone customerPhone) {
		getCustomerPhones().remove(customerPhone);
		customerPhone.setCustomerIdentifier(null);

		return customerPhone;
	}

	public List<OrganizationMapper> getOrganizationMappers() {
		return this.organizationMappers;
	}

	public void setOrganizationMappers(List<OrganizationMapper> organizationMappers) {
		this.organizationMappers = organizationMappers;
	}

	public OrganizationMapper addOrganizationMapper(OrganizationMapper organizationMapper) {
		getOrganizationMappers().add(organizationMapper);
		organizationMapper.setCustomerIdentifier(this);

		return organizationMapper;
	}

	public OrganizationMapper removeOrganizationMapper(OrganizationMapper organizationMapper) {
		getOrganizationMappers().remove(organizationMapper);
		organizationMapper.setCustomerIdentifier(null);

		return organizationMapper;
	}

}