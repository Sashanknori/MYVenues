package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CUSTOMER_ALERTS database table.
 * 
 */
@Entity
@Table(name="CUSTOMER_ALERTS")
@NamedQuery(name="CustomerAlert.findAll", query="SELECT c FROM CustomerAlert c")
public class CustomerAlert implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CustomerAlertPK id;

	@Column(name="DO_SEND_MAIL_ALERTS", nullable=false, length=1)
	private String doSendMailAlerts;

	@Column(name="DO_SEND_SMS_ALERTS", nullable=false, length=1)
	private String doSendSmsAlerts;

	@Column(name="LAST_ALERT_SENT", nullable=false)
	private Timestamp lastAlertSent;

	public CustomerAlert() {
	}

	public CustomerAlertPK getId() {
		return this.id;
	}

	public void setId(CustomerAlertPK id) {
		this.id = id;
	}

	public String getDoSendMailAlerts() {
		return this.doSendMailAlerts;
	}

	public void setDoSendMailAlerts(String doSendMailAlerts) {
		this.doSendMailAlerts = doSendMailAlerts;
	}

	public String getDoSendSmsAlerts() {
		return this.doSendSmsAlerts;
	}

	public void setDoSendSmsAlerts(String doSendSmsAlerts) {
		this.doSendSmsAlerts = doSendSmsAlerts;
	}

	public Timestamp getLastAlertSent() {
		return this.lastAlertSent;
	}

	public void setLastAlertSent(Timestamp lastAlertSent) {
		this.lastAlertSent = lastAlertSent;
	}

}