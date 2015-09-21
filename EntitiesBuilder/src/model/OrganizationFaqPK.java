package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORGANIZATION_FAQ database table.
 * 
 */
@Embeddable
public class OrganizationFaqPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORGANIZATION_ID", insertable=false, updatable=false, unique=true, nullable=false, length=10)
	private String organizationId;

	@Column(name="QUESTION_ID", unique=true, nullable=false)
	private int questionId;

	public OrganizationFaqPK() {
	}
	public String getOrganizationId() {
		return this.organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public int getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrganizationFaqPK)) {
			return false;
		}
		OrganizationFaqPK castOther = (OrganizationFaqPK)other;
		return 
			this.organizationId.equals(castOther.organizationId)
			&& (this.questionId == castOther.questionId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.organizationId.hashCode();
		hash = hash * prime + this.questionId;
		
		return hash;
	}
}