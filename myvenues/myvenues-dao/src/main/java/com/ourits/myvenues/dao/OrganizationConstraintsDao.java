package com.ourits.myvenues.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ourits.myvenues.entities.OrganizationConstraint;

@Stateless
public class OrganizationConstraintsDao {

	@PersistenceContext(unitName = "myvenues")
	private EntityManager entityManager;

	public List<OrganizationConstraint> retrieveAllOrganizationConstraintDetails() {
		System.out.println("********************");
		final Query query = entityManager.createNamedQuery("OrganizationConstraint.findAll");
		return query.getResultList();

	}

	public void persistOrganizationConstraints(OrganizationConstraint organizationConstraint) {
		entityManager.persist(organizationConstraint);
		System.out.println("persisted");
	}

}
