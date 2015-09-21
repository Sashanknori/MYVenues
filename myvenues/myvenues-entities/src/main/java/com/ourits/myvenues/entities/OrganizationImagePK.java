package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORGANIZATION_IMAGES database table.
 * 
 */
@Embeddable
public class OrganizationImagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORGANIZATION_ID", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String organizationId;

	@Column(name="IMAGE_SEQ_ID", unique=true, nullable=false)
	private int imageSeqId;

	public OrganizationImagePK() {
	}
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public int getImageSeqId() {
		return this.imageSeqId;
	}
	public void setImageSeqId(int imageSeqId) {
		this.imageSeqId = imageSeqId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrganizationImagePK)) {
			return false;
		}
		OrganizationImagePK castOther = (OrganizationImagePK)other;
		return 
			this.organizationId.equals(castOther.organizationId)
			&& (this.imageSeqId == castOther.imageSeqId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId.hashCode();
		hash = hash * prime + this.imageSeqId;
		
		return hash;
	}
}