package com.ourits.myvenues.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ourits.myvenues.entities.CustomerIdentifier;

@Stateless
@SuppressWarnings("unchecked")
public class CustomerDetailsDao {

	@PersistenceContext(unitName = "myvenues")
	private EntityManager entityManager;

	public List<CustomerIdentifier> retrieveAllCustomers() {
		System.out.println("********************");
		final Query query = entityManager
				.createNamedQuery("CustomerIdentifier.findAll");
		return query.getResultList();

	}

}
