package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the EVENT_SUPPORT_DETAILS database table.
 * 
 */
@Embeddable
public class EventSupportDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORGANIZATION_ID", unique=true, nullable=false, length=10)
	private String organizationId;

	@Column(name="EVENT_SEQ_NUM", unique=true, nullable=false)
	private int eventSeqNum;

	public EventSupportDetailPK() {
	}
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public int getEventSeqNum() {
		return this.eventSeqNum;
	}
	public void setEventSeqNum(int eventSeqNum) {
		this.eventSeqNum = eventSeqNum;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventSupportDetailPK)) {
			return false;
		}
		EventSupportDetailPK castOther = (EventSupportDetailPK)other;
		return 
			this.organizationId.equals(castOther.organizationId)
			&& (this.eventSeqNum == castOther.eventSeqNum);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId.hashCode();
		hash = hash * prime + this.eventSeqNum;
		
		return hash;
	}
}