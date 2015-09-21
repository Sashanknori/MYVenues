package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ORGANIZATION_AVAILABILITY database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION_AVAILABILITY")
@NamedQuery(name="OrganizationAvailability.findAll", query="SELECT o FROM OrganizationAvailability o")
public class OrganizationAvailability implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrganizationAvailabilityPK id;

	@Column(name="BOOKED_STRT_DATE", nullable=false)
	private Timestamp bookedStrtDate;

	@Column(name="BOOKING_END_DATE", nullable=false)
	private Timestamp bookingEndDate;

	@Column(name="BOOKING_SEQ_NUM")
	private int bookingSeqNum;

	@Column(name="LAST_MODIFIED", nullable=false)
	private Timestamp lastModified;

	//bi-directional one-to-one association to OrganizationMapper
	@OneToOne
	@JoinColumns({
		@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="CUSTOMER_TYPE", referencedColumnName="CUSTOMER_TYPE", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="ORGANIZATION_ID", referencedColumnName="ORGANIZATION_ID", nullable=false, insertable=false, updatable=false)
		})
	private OrganizationMapper organizationMapper;

	public OrganizationAvailability() {
	}

	public OrganizationAvailabilityPK getId() {
		return this.id;
	}

	public void setId(OrganizationAvailabilityPK id) {
		this.id = id;
	}

	public Timestamp getBookedStrtDate() {
		return this.bookedStrtDate;
	}

	public void setBookedStrtDate(Timestamp bookedStrtDate) {
		this.bookedStrtDate = bookedStrtDate;
	}

	public Timestamp getBookingEndDate() {
		return this.bookingEndDate;
	}

	public void setBookingEndDate(Timestamp bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public int getBookingSeqNum() {
		return this.bookingSeqNum;
	}

	public void setBookingSeqNum(int bookingSeqNum) {
		this.bookingSeqNum = bookingSeqNum;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public OrganizationMapper getOrganizationMapper() {
		return this.organizationMapper;
	}

	public void setOrganizationMapper(OrganizationMapper organizationMapper) {
		this.organizationMapper = organizationMapper;
	}

}