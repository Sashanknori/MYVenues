package com.ourits.myvenues.business.service;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.collections.CollectionUtils;

import com.ourits.myvenues.dao.CustomerDetailsDao;
import com.ourits.myvenues.dao.OrganizationConstraintsDao;
import com.ourits.myvenues.dao.OrganizationDetailsDao;
import com.ourits.myvenues.dao.OrganizationFaqDao;
import com.ourits.myvenues.entities.CustomerIdentifier;
import com.ourits.myvenues.entities.CustomerIdentifierPK;
import com.ourits.myvenues.entities.OrganizationConstraint;
import com.ourits.myvenues.entities.OrganizationConstraintPK;
import com.ourits.myvenues.entities.OrganizationDetail;
import com.ourits.myvenues.entities.OrganizationFaq;
import com.ourits.myvenues.entities.OrganizationFaqPK;
import com.ourits.myvenues.schema.request.layouts.CustomerOnboardingDetailsRequest;
import com.ourits.myvenues.schema.request.layouts.FrequentlyAnsweredQuestions;
import com.ourits.myvenues.schema.request.layouts.OnboardingDetailsRequest;
import com.ourits.myvenues.schema.request.layouts.OrganizationOnboardingDetailsRequest;
import com.ourits.myvenues.schema.request.layouts.OrganizationPolicies;

@Stateless
public class CustomerDetailsPersistenceBusinessService {

	@EJB
	CustomerDetailsDao customerDetailsDao;

	@EJB
	OrganizationDetailsDao organizationDetailsDao;

	@EJB
	OrganizationConstraintsDao organizationConstraintsDao;

	@EJB
	OrganizationFaqDao organizationFaqDao;

	public void performCustomerDetailsPersistence(OnboardingDetailsRequest onboardingDetailsRequest) {
		final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// parent table for customer details
		persistCustomerIdentifierDetails(onboardingDetailsRequest.getCustomerOnboardingDetailsRequest(), timestamp);
		// parent table for organization details
		persistOrganizationDetails(onboardingDetailsRequest.getOrganizationOnboardingDetailsRequest(), timestamp);

	}

	private void persistOrganizationDetails(OrganizationOnboardingDetailsRequest organizationOnboardingDetailsRequest,
			Timestamp timestamp) {
		OrganizationDetail organizationDetail = new OrganizationDetail();

		organizationDetail.setDiningFacility(organizationOnboardingDetailsRequest.getDiningFacility());
		organizationDetail.setHasDecorator(organizationOnboardingDetailsRequest.getHasDecorator());
		organizationDetail.setHasLightingOption(organizationOnboardingDetailsRequest.getHasLightingOption());
		organizationDetail.setHasPowerBackUp(organizationOnboardingDetailsRequest.getHasPowerBackUp());
		organizationDetail.setHasSoundOption(organizationOnboardingDetailsRequest.getHasSoundOption());
		organizationDetail.setIsAirConditionedFlag(organizationOnboardingDetailsRequest.getIsAirConditionedFlag());
		organizationDetail.setLastModified(organizationOnboardingDetailsRequest.getLastModified());
		organizationDetail.setLiquorAllowed(organizationOnboardingDetailsRequest.getLiquorAllowed());
		organizationDetail.setNonVegAllowedFlag(organizationOnboardingDetailsRequest.getNonVegAllowedFlag());
		organizationDetail.setNumberOfAcRooms(organizationOnboardingDetailsRequest.getNumberOfAcRooms());
		organizationDetail.setNumberOfHalls(organizationOnboardingDetailsRequest.getNumberOfHalls());
		organizationDetail.setNumberOfNonAcRooms(organizationOnboardingDetailsRequest.getNumberOfNonAcRooms());
		organizationDetail.setOrganizationEstdDate(organizationOnboardingDetailsRequest.getOrganizationEstdDate());
		organizationDetail.setOrganizationId(organizationOnboardingDetailsRequest.getOrganizationId());
		// TODO For future purpose
		// organizationDetail.setOrganizationImages(organizationOnboardingDetailsRequest.getOrganizationImages());
		organizationDetail.setOrganizationType(organizationOnboardingDetailsRequest.getOrganizationType());
		organizationDetail.setParkingCapacity(organizationOnboardingDetailsRequest.getParkingCapacity());
		organizationDetail.setReligiousAffliations(organizationOnboardingDetailsRequest.getReligiousAffliations());
		organizationDetail.setSeatingCapacity(organizationOnboardingDetailsRequest.getSeatingCapacity());
		organizationDetail.setStaffSize(organizationOnboardingDetailsRequest.getStaffSize());
		organizationDetailsDao.persistCustomerIdentifierDetails(organizationDetail);

		if (CollectionUtils.isNotEmpty(organizationOnboardingDetailsRequest.getOrganizationConstraints())) {
			buildAndPersistOrganizationConstraints(organizationOnboardingDetailsRequest.getOrganizationConstraints(),
					organizationDetail, timestamp);
		}
		if (CollectionUtils.isNotEmpty(organizationOnboardingDetailsRequest.getOrganizationFaqs())) {
			buildAndPersistdOrganizationFaqs(organizationOnboardingDetailsRequest.getOrganizationFaqs(),
					organizationDetail, timestamp);
		}
	}

	private void buildAndPersistdOrganizationFaqs(List<FrequentlyAnsweredQuestions> organizationFaqsList,
			OrganizationDetail organizationDetail, Timestamp timestamp) {

		OrganizationFaq organizationFaq = null;
		OrganizationFaqPK id;

		for (FrequentlyAnsweredQuestions frequentlyAnsweredQuestions : organizationFaqsList) {
			organizationFaq = new OrganizationFaq();
			organizationFaq.setAnswer(frequentlyAnsweredQuestions.getAnswer());
			id = new OrganizationFaqPK();
			id.setOrganizationId(organizationDetail.getOrganizationId());
			id.setQuestionId(frequentlyAnsweredQuestions.getQuestionId());
			organizationFaq.setId(id);
			organizationFaq.setLastModified(timestamp);
			organizationFaq.setOrganizationDetail(organizationDetail);
			organizationFaq.setQuestion(frequentlyAnsweredQuestions.getQuestion());

		}

	}

	private void buildAndPersistOrganizationConstraints(List<OrganizationPolicies> organizationConstraintsList,
			final OrganizationDetail organizationDetail, Timestamp timestamp) {
		OrganizationConstraint organizationConstraint = null;
		OrganizationConstraintPK id = null;
		for (final OrganizationPolicies organizationPolicies : organizationConstraintsList) {
			organizationConstraint = new OrganizationConstraint();
			organizationConstraint.setConstraintDescription(organizationPolicies.getConstraintDescription());
			organizationConstraint.setConstraintType(organizationPolicies.getConstraintType());
			id = new OrganizationConstraintPK();
			id.setConstraintId(organizationPolicies.getConstraintId());
			id.setOrganizationId(organizationDetail.getOrganizationId());
			organizationConstraint.setId(id);
			organizationConstraint.setLastModified(timestamp);
			organizationConstraint.setOrganizationDetail(organizationDetail);
			organizationConstraintsDao.persistOrganizationConstraints(organizationConstraint);

		}

	}

	private void persistCustomerIdentifierDetails(CustomerOnboardingDetailsRequest customerOnboardingDetailsRequest,
			Timestamp timestamp) {
		final CustomerIdentifier customerIdentifier = new CustomerIdentifier();

		CustomerIdentifierPK id = new CustomerIdentifierPK();
		id.setCustomerId(customerOnboardingDetailsRequest.getCustomerIdentifier());
		id.setCustomerType(customerOnboardingDetailsRequest.getCustomertype());
		customerIdentifier.setId(id);

		customerIdentifier
				.setCustomerAddressRefNum(customerOnboardingDetailsRequest.getAddressReferenceNumber().intValue());

		customerIdentifier.setCustomerCreateDate(timestamp);

		customerIdentifier
				.setCustomerEmailRefNum(customerOnboardingDetailsRequest.getEmailReferenceNumber().intValue());

		customerIdentifier.setCustomerNameRefNum(customerOnboardingDetailsRequest.getNameReferenceNumber().intValue());

		customerIdentifier
				.setCustomerPhoneRefNum(customerOnboardingDetailsRequest.getPhoneReferenceNumber().intValue());

		customerIdentifier.setCustomerSubscriptionStatus(customerOnboardingDetailsRequest.getSubscriptionStatus());

		customerIdentifier.setLastModifiedDate(timestamp);

		customerDetailsDao.persistCustomerIdentifierDetails(customerIdentifier);
	}

}
