package com.ourits.myvenues.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.ourits.myvenues.entities.CustomerIdentifier;

@Stateless
@SuppressWarnings("unchecked")
public class CustomerDetailsDao {

	@PersistenceContext(unitName = "myvenues", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

	public List<CustomerIdentifier> retrieveAllCustomers() {
		final Query query = entityManager
				.createNamedQuery("SELECT customerDetails from CustomerIdentifier as customerDetails");
		return query.getResultList();

	}

}
