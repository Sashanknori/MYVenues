package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORGANIZATION_CONSTRAINTS database table.
 * 
 */
@Embeddable
public class OrganizationConstraintPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORGANIZATION_ID", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String organizationId;

	@Column(name="CONSTRAINT_ID", unique=true, nullable=false)
	private int constraintId;

	public OrganizationConstraintPK() {
	}
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public int getConstraintId() {
		return this.constraintId;
	}
	public void setConstraintId(int constraintId) {
		this.constraintId = constraintId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrganizationConstraintPK)) {
			return false;
		}
		OrganizationConstraintPK castOther = (OrganizationConstraintPK)other;
		return 
			this.organizationId.equals(castOther.organizationId)
			&& (this.constraintId == castOther.constraintId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId.hashCode();
		hash = hash * prime + this.constraintId;
		
		return hash;
	}
}