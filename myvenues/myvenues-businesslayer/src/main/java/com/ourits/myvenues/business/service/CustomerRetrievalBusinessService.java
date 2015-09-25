package com.ourits.myvenues.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ourits.myvenues.dao.CustomerDetailsDao;
import com.ourits.myvenues.entities.CustomerIdentifier;

@Stateless
public class CustomerRetrievalBusinessService {

	@EJB
	CustomerDetailsDao customerDetailsDao;

	public void processCustomerDetailsRetrieval() {
		List<CustomerIdentifier> customerDetailsList = customerDetailsDao.retrieveAllCustomers();
		for (final CustomerIdentifier customerIdentifier : customerDetailsList) {
			System.out.println(customerIdentifier.getId().getCustomerId() + "---->"
					+ customerIdentifier.getCustomerAddressRefNum());

		}

	}

}
