package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CUSTOMER_ADDRESS database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_ADDRESS")
@NamedQuery(name="CustomerAddress.findAll", query="SELECT c FROM CustomerAddress c")
public class CustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerAddressPK id;

	@Column(name="ADDRESS_TYPE", nullable=false, length=1)
	private String addressType;

	@Column(name="APPT_NO", length=10)
	private String apptNo;

	@Column(name="CITY", length=20)
	private String city;

	@Column(name="COUNTRY", nullable=false, length=20)
	private String country;

	@Column(name="CREATE_DATE", nullable=false)
	private Timestamp createDate;

	@Column(name="HOUSE_NUMBER", nullable=false, length=50)
	private String houseNumber;

	@Column(name="PREFERRED_ADDRESS_FLAG", nullable=false, length=1)
	private String preferredAddressFlag;

	@Column(name="STATE", nullable=false, length=20)
	private String state;

	@Column(name="STREET", length=50)
	private String street;

	//bi-directional many-to-one association to CustomerIdentifier
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_TYPE", referencedColumnName="CUSTOMER_TYPE", nullable=false, insertable=false, updatable=false)
		})
	private CustomerIdentifier customerIdentifier;

	public CustomerAddress() {
	}

	public CustomerAddressPK getId() {
		return this.id;
	}

	public void setId(CustomerAddressPK id) {
		this.id = id;
	}

	public String getAddressType() {
		return this.addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getApptNo() {
		return this.apptNo;
	}

	public void setApptNo(String apptNo) {
		this.apptNo = apptNo;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getHouseNumber() {
		return this.houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPreferredAddressFlag() {
		return this.preferredAddressFlag;
	}

	public void setPreferredAddressFlag(String preferredAddressFlag) {
		this.preferredAddressFlag = preferredAddressFlag;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return this.customerIdentifier;
	}

	public void setCustomerIdentifier(CustomerIdentifier customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}