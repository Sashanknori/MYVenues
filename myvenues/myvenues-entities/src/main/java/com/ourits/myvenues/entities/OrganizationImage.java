package com.ourits.myvenues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ORGANIZATION_IMAGES database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION_IMAGES")
@NamedQuery(name="OrganizationImage.findAll", query="SELECT o FROM OrganizationImage o")
public class OrganizationImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrganizationImagePK id;

	@Column(name="ACTIVE_IMAGE", nullable=false, length=1)
	private String activeImage;

	@Lob
	@Column(name="IMAGE", nullable=false)
	private byte[] image;

	@Column(name="LAST_MODIFIED", nullable=false)
	private Timestamp lastModified;

	//bi-directional many-to-one association to OrganizationDetail
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID", nullable=false, insertable=false, updatable=false)
	private OrganizationDetail organizationDetail;

	public OrganizationImage() {
	}

	public OrganizationImagePK getId() {
		return this.id;
	}

	public void setId(OrganizationImagePK id) {
		this.id = id;
	}

	public String getActiveImage() {
		return this.activeImage;
	}

	public void setActiveImage(String activeImage) {
		this.activeImage = activeImage;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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