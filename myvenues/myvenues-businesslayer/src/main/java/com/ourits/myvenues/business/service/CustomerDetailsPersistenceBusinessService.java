package com.ourits.myvenues.business.service;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ourits.myvenues.dao.CustomerDetailsDao;
import com.ourits.myvenues.entities.CustomerIdentifier;
import com.ourits.myvenues.entities.CustomerIdentifierPK;
import com.ourits.myvenues.schema.request.layouts.CustomerOnboardingDetailsRequest;
import com.ourits.myvenues.schema.request.layouts.OnboardingDetailsRequest;

@Stateless
public class CustomerDetailsPersistenceBusinessService {

	@EJB
	CustomerDetailsDao customerDetailsDao;

	public void performCustomerDetailsPersistence(OnboardingDetailsRequest onboardingDetailsRequest) {
		persisCustomerIdentifierDetails(onboardingDetailsRequest.getCustomerOnboardingDetailsRequest());

	}

	private void persisCustomerIdentifierDetails(CustomerOnboardingDetailsRequest customerOnboardingDetailsRequest) {
		CustomerIdentifier customerIdentifier = new CustomerIdentifier();

		CustomerIdentifierPK id = new CustomerIdentifierPK();
		id.setCustomerId(customerOnboardingDetailsRequest.getCustomerIdentifier());
		id.setCustomerType(customerOnboardingDetailsRequest.getCustomertype());
		customerIdentifier.setId(id);

		customerIdentifier
				.setCustomerAddressRefNum(customerOnboardingDetailsRequest.getAddressReferenceNumber().intValue());

		customerIdentifier.setCustomerCreateDate(new Timestamp(System.currentTimeMillis()));

		customerIdentifier
				.setCustomerEmailRefNum(customerOnboardingDetailsRequest.getEmailReferenceNumber().intValue());

		customerIdentifier.setCustomerNameRefNum(customerOnboardingDetailsRequest.getNameReferenceNumber().intValue());

		customerIdentifier
				.setCustomerPhoneRefNum(customerOnboardingDetailsRequest.getPhoneReferenceNumber().intValue());

		customerIdentifier.setCustomerSubscriptionStatus(customerOnboardingDetailsRequest.getSubscriptionStatus());

		customerIdentifier.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));

		customerDetailsDao.persistCustomerIdentifierDetails(customerIdentifier);
	}

}
