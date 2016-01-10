package com.ourits.myvenues.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ourits.myvenues.entities.OrganizationDetail;

@Stateless
public class OrganizationDetailsDao {

	@PersistenceContext(unitName = "myvenues")
	private EntityManager entityManager;

	public List<OrganizationDetail> retrieveAllOrganizationDetails() {
		System.out.println("********************");
		final Query query = entityManager.createNamedQuery("OrganizationDetail.findAll");
		return query.getResultList();

	}

	public void persistCustomerIdentifierDetails(OrganizationDetail organizationDetail) {
		entityManager.persist(organizationDetail);
		System.out.println("persisted");
	}

}
