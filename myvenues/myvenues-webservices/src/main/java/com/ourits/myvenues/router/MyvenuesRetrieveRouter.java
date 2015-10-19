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

import com.ourits.myvenues.business.service.CustomerRetrievalBusinessService;

@Path("/retrievalRouter")
@Stateless
public class MyvenuesRetrieveRouter {

	private static final Logger logger = LoggerFactory.getLogger(MyvenuesRetrieveRouter.class);
	@EJB
	private CustomerRetrievalBusinessService customerRetrievalBusinessService;

	@POST
	@Path("/retrieveCustomerDetails")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.TEXT_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.TEXT_XML })
	public void retrieveCustomerDetails() {
		logger.debug("Entering retrieveCustomerDetails with parameters : {}");
		customerRetrievalBusinessService.processCustomerDetailsRetrieval();
		logger.debug("Exiting retrieveCustomerDetails with parameters : {}");

	}
}
