package com.ourits.myvenues.schema.request.layouts;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.ourit.myvenues.schema.helpers.TimestampAdapter;

@XmlRootElement(name = "customerOnboardingDetailsRequest")
public class CustomerOnboardingDetailsRequest {

	private String customerIdentifier;
	private String customertype;
	private BigInteger nameReferenceNumber;
	private BigInteger addressReferenceNumber;
	private BigInteger emailReferenceNumber;
	private BigInteger phoneReferenceNumber;
	private Timestamp customerCreateDate;
	private Timestamp lastModifiedDate;
	private String subscriptionStatus;

	@XmlJavaTypeAdapter(TimestampAdapter.class)
	public Timestamp getCustomerCreateDate() {
		return customerCreateDate;
	}

	public void setCustomerCreateDate(Timestamp customerCreateDate) {
		this.customerCreateDate = customerCreateDate;
	}

	@XmlJavaTypeAdapter(TimestampAdapter.class)
	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

	public String getCustomertype() {
		return customertype;
	}

	public void setCustomertype(String customertype) {
		this.customertype = customertype;
	}

	public BigInteger getNameReferenceNumber() {
		return nameReferenceNumber;
	}

	public void setNameReferenceNumber(BigInteger nameReferenceNumber) {
		this.nameReferenceNumber = nameReferenceNumber;
	}

	public BigInteger getAddressReferenceNumber() {
		return addressReferenceNumber;
	}

	public void setAddressReferenceNumber(BigInteger addressReferenceNumber) {
		this.addressReferenceNumber = addressReferenceNumber;
	}

	public BigInteger getEmailReferenceNumber() {
		return emailReferenceNumber;
	}

	public void setEmailReferenceNumber(BigInteger emailReferenceNumber) {
		this.emailReferenceNumber = emailReferenceNumber;
	}

	public BigInteger getPhoneReferenceNumber() {
		return phoneReferenceNumber;
	}

	public void setPhoneReferenceNumber(BigInteger phoneReferenceNumber) {
		this.phoneReferenceNumber = phoneReferenceNumber;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

}
