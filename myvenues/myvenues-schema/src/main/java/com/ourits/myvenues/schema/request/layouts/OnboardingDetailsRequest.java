package com.ourits.myvenues.schema.request.layouts;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "onboardingDetailsRequest")
public class OnboardingDetailsRequest {
	private OperationType operationType;
	private CustomerOnboardingDetailsRequest customerOnboardingDetailsRequest;
	private OrganizationOnboardingDetailsRequest organizationOnboardingDetailsRequest;

	public CustomerOnboardingDetailsRequest getCustomerOnboardingDetailsRequest() {
		return customerOnboardingDetailsRequest;
	}

	public void setCustomerOnboardingDetailsRequest(CustomerOnboardingDetailsRequest customerOnboardingDetailsRequest) {
		this.customerOnboardingDetailsRequest = customerOnboardingDetailsRequest;
	}

	public OrganizationOnboardingDetailsRequest getOrganizationOnboardingDetailsRequest() {
		return organizationOnboardingDetailsRequest;
	}

	public void setOrganizationOnboardingDetailsRequest(
			OrganizationOnboardingDetailsRequest organizationOnboardingDetailsRequest) {
		this.organizationOnboardingDetailsRequest = organizationOnboardingDetailsRequest;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

}
