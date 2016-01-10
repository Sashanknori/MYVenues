package com.ourits.myvenues.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ourits.myvenues.entities.OrganizationFaq;

@Stateless
public class OrganizationFaqDao {

	@PersistenceContext(unitName = "myvenues")
	private EntityManager entityManager;

	public List<OrganizationFaq> retrieveAllOrganizationFaqDetails() {
		System.out.println("********************");
		final Query query = entityManager.createNamedQuery("OrganizationFaq.findAll");
		return query.getResultList();

	}

	public void persistOrganizationFaqDetails(OrganizationFaq organizationFaq) {
		entityManager.persist(organizationFaq);
		System.out.println("persisted");
	}

}
