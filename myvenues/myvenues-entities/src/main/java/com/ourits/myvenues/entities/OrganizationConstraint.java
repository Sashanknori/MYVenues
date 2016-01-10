package com.ourits.myvenues.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ORGANIZATION_CONSTRAINTS database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION_CONSTRAINTS")
@NamedQuery(name="OrganizationConstraint.findAll", query="SELECT o FROM OrganizationConstraint o")
public class OrganizationConstraint implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrganizationConstraintPK id;

	@Column(name="CONSTRAINT_DESCRIPTION", nullable=false, length=255)
	private String constraintDescription;

	@Column(name="CONSTRAINT_TYPE", length=255)
	private String constraintType;

	@Column(name="IS_ACTIVE_CONSTRAINT", length=1)
	private String isActiveConstraint;

	@Column(name="LAST_MODIFIED", nullable=false)
	private Timestamp lastModified;

	//bi-directional many-to-one association to OrganizationDetail
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID", nullable=false, insertable=false, updatable=false)
	private OrganizationDetail organizationDetail;

	public OrganizationConstraint() {
	}

	public OrganizationConstraintPK getId() {
		return this.id;
	}

	public void setId(OrganizationConstraintPK id) {
		this.id = id;
	}

	public String getConstraintDescription() {
		return this.constraintDescription;
	}

	public void setConstraintDescription(String constraintDescription) {
		this.constraintDescription = constraintDescription;
	}

	public String getConstraintType() {
		return this.constraintType;
	}

	public void setConstraintType(String constraintType) {
		this.constraintType = constraintType;
	}

	public String getIsActiveConstraint() {
		return this.isActiveConstraint;
	}

	public void setIsActiveConstraint(String isActiveConstraint) {
		this.isActiveConstraint = isActiveConstraint;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public OrganizationDetail getOrganizationDetail() {
		return this.organizationDetail;
	}

	public void setOrganizationDetail(OrganizationDetail organizationDetail) {
		this.organizationDetail = organizationDetail;
	}

}