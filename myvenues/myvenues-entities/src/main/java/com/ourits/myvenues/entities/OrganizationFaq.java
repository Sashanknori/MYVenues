package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ORGANIZATION_FAQ database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION_FAQ")
@NamedQuery(name="OrganizationFaq.findAll", query="SELECT o FROM OrganizationFaq o")
public class OrganizationFaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrganizationFaqPK id;

	@Column(name="ANSWER", nullable=false, length=255)
	private String answer;

	@Column(name="LAST_MODIFIED", nullable=false)
	private Timestamp lastModified;

	@Column(name="QUESTION", nullable=false, length=255)
	private String question;

	//bi-directional many-to-one association to OrganizationDetail
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID", nullable=false, insertable=false, updatable=false)
	private OrganizationDetail organizationDetail;

	public OrganizationFaq() {
	}

	public OrganizationFaqPK getId() {
		return this.id;
	}

	public void setId(OrganizationFaqPK id) {
		this.id = id;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public OrganizationDetail getOrganizationDetail() {
		return this.organizationDetail;
	}

	public void setOrganizationDetail(OrganizationDetail organizationDetail) {
		this.organizationDetail = organizationDetail;
	}

}