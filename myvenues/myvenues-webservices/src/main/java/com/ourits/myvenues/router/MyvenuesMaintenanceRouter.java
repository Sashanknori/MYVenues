package com.ourits.myvenues.router;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ourit.myvenues.schema.helpers.TransactionStatusSchema;
import com.ourits.myvenues.business.service.CustomerDetailsPersistenceBusinessService;
import com.ourits.myvenues.schema.request.layouts.OnboardingDetailsRequest;

@Path("/maintenanceRouter")
@Stateless
public class MyvenuesMaintenanceRouter {

	private static final Logger logger = LoggerFactory.getLogger(MyvenuesMaintenanceRouter.class);

	@EJB
	private CustomerDetailsPersistenceBusinessService customerDetailsPersistenceBusinessService;

	@POST
	@Path("/persistCustomerDetails")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.TEXT_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.TEXT_XML })
	public TransactionStatusSchema persistCustomerDetails(final OnboardingDetailsRequest onboardingDetailsRequest) {
		logger.debug("Entering persistCustomerDetails with parameters {}", onboardingDetailsRequest);
		customerDetailsPersistenceBusinessService.performCustomerDetailsPersistence(onboardingDetailsRequest);
		logger.debug("Exiting persistCustomerDetails with parameters {}", onboardingDetailsRequest);
		TransactionStatusSchema transactionStatusSchema = new TransactionStatusSchema();
		return transactionStatusSchema;

	}

}
