package com.ourits.myvenues.router;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ourit.myvenues.schema.helpers.TransactionStatusSchema;

@Path("/maintenanceRouter")
public class MyvenuesMaintenanceRouter {

	@POST
	@Path("/persistCustomerDetails")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.TEXT_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.TEXT_XML })
	public TransactionStatusSchema persistCustomerDetails() {
		return null;

	}
}
