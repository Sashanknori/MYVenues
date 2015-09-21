package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CUSTOMER_EMAIL database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_EMAIL")
@NamedQuery(name="CustomerEmail.findAll", query="SELECT c FROM CustomerEmail c")
public class CustomerEmail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerEmailPK id;

	@Column(name="CREATE_DATE", nullable=false)
	private Timestamp createDate;

	@Column(name="EMAIL_ID", nullable=false, length=100)
	private String emailId;

	@Column(name="EMAIL_TYPE", nullable=false, length=1)
	private String emailType;

	@Column(name="PREFERRED_EMAILID_FLAG", nullable=false, length=1)
	private String preferredEmailidFlag;

	//bi-directional many-to-one association to CustomerIdentifier
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_TYPE", referencedColumnName="CUSTOMER_TYPE", nullable=false, insertable=false, updatable=false)
		})
	private CustomerIdentifier customerIdentifier;

	public CustomerEmail() {
	}

	public CustomerEmailPK getId() {
		return this.id;
	}

	public void setId(CustomerEmailPK id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public String getPreferredEmailidFlag() {
		return this.preferredEmailidFlag;
	}

	public void setPreferredEmailidFlag(String preferredEmailidFlag) {
		this.preferredEmailidFlag = preferredEmailidFlag;
	}

	public CustomerIdentifier getCustomerIdentifier() {
		return this.customerIdentifier;
	}

	public void setCustomerIdentifier(CustomerIdentifier customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
	}

}