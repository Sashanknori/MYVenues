package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the EVENT_SUPPORT_DETAILS database table.
 * 
 */
@Entity
@Table(name="EVENT_SUPPORT_DETAILS")
@NamedQuery(name="EventSupportDetail.findAll", query="SELECT e FROM EventSupportDetail e")
public class EventSupportDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventSupportDetailPK id;

	@Column(name="EVENT_ALLOWED_INDICATOR", nullable=false, length=1)
	private String eventAllowedIndicator;

	@Column(name="EVENT_NAME", nullable=false, length=15)
	private String eventName;

	@Column(name="LAST_MODIFIED", nullable=false)
	private Timestamp lastModified;

	public EventSupportDetail() {
	}

	public EventSupportDetailPK getId() {
		return this.id;
	}

	public void setId(EventSupportDetailPK id) {
		this.id = id;
	}

	public String getEventAllowedIndicator() {
		return this.eventAllowedIndicator;
	}

	public void setEventAllowedIndicator(String eventAllowedIndicator) {
		this.eventAllowedIndicator = eventAllowedIndicator;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

}