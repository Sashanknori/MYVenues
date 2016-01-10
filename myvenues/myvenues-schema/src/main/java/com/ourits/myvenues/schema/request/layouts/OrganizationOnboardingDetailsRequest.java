package com.ourits.myvenues.schema.request.layouts;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrganizationOnboardingDetailsRequest {

	private Integer diningFacility;
	private String hasDecorator;
	private String hasLightingOption;
	private String hasPowerBackUp;
	private String hasSoundOption;
	private String isAirConditionedFlag;
	private Timestamp lastModified;
	private String liquorAllowed;
	private String nonVegAllowedFlag;
	private Integer numberOfAcRooms;
	private Integer numberOfHalls;
	private Integer numberOfNonAcRooms;
	private List<OrganizationPolicies> organizationConstraints;
	private Date organizationEstdDate;
	private List<FrequentlyAnsweredQuestions> organizationFaqs;
	private String organizationId;
	private List<OrganizationImages> organizationImages;
	private String organizationType;
	private Integer parkingCapacity;
	private String religiousAffliations;
	private Integer seatingCapacity;
	private Integer staffSize;

	public Integer getDiningFacility() {
		return diningFacility;
	}

	public void setDiningFacility(Integer diningFacility) {
		this.diningFacility = diningFacility;
	}

	public String getHasDecorator() {
		return hasDecorator;
	}

	public void setHasDecorator(String hasDecorator) {
		this.hasDecorator = hasDecorator;
	}

	public String getHasLightingOption() {
		return hasLightingOption;
	}

	public void setHasLightingOption(String hasLightingOption) {
		this.hasLightingOption = hasLightingOption;
	}

	public String getHasPowerBackUp() {
		return hasPowerBackUp;
	}

	public void setHasPowerBackUp(String hasPowerBackUp) {
		this.hasPowerBackUp = hasPowerBackUp;
	}

	public String getHasSoundOption() {
		return hasSoundOption;
	}

	public void setHasSoundOption(String hasSoundOption) {
		this.hasSoundOption = hasSoundOption;
	}

	public String getIsAirConditionedFlag() {
		return isAirConditionedFlag;
	}

	public void setIsAirConditionedFlag(String isAirConditionedFlag) {
		this.isAirConditionedFlag = isAirConditionedFlag;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getLiquorAllowed() {
		return liquorAllowed;
	}

	public void setLiquorAllowed(String liquorAllowed) {
		this.liquorAllowed = liquorAllowed;
	}

	public String getNonVegAllowedFlag() {
		return nonVegAllowedFlag;
	}

	public void setNonVegAllowedFlag(String nonVegAllowedFlag) {
		this.nonVegAllowedFlag = nonVegAllowedFlag;
	}

	public Integer getNumberOfAcRooms() {
		return numberOfAcRooms;
	}

	public void setNumberOfAcRooms(Integer numberOfAcRooms) {
		this.numberOfAcRooms = numberOfAcRooms;
	}

	public Integer getNumberOfHalls() {
		return numberOfHalls;
	}

	public void setNumberOfHalls(Integer numberOfHalls) {
		this.numberOfHalls = numberOfHalls;
	}

	public Integer getNumberOfNonAcRooms() {
		return numberOfNonAcRooms;
	}

	public void setNumberOfNonAcRooms(Integer numberOfNonAcRooms) {
		this.numberOfNonAcRooms = numberOfNonAcRooms;
	}

	

	public Date getOrganizationEstdDate() {
		return organizationEstdDate;
	}

	public void setOrganizationEstdDate(Date organizationEstdDate) {
		this.organizationEstdDate = organizationEstdDate;
	}

	public List<FrequentlyAnsweredQuestions> getOrganizationFaqs() {
		return organizationFaqs;
	}

	public void setOrganizationFaqs(List<FrequentlyAnsweredQuestions> organizationFaqs) {
		this.organizationFaqs = organizationFaqs;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public List<OrganizationImages> getOrganizationImages() {
		return organizationImages;
	}

	public void setOrganizationImages(List<OrganizationImages> organizationImages) {
		this.organizationImages = organizationImages;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public Integer getParkingCapacity() {
		return parkingCapacity;
	}

	public void setParkingCapacity(Integer parkingCapacity) {
		this.parkingCapacity = parkingCapacity;
	}

	public String getReligiousAffliations() {
		return religiousAffliations;
	}

	public void setReligiousAffliations(String religiousAffliations) {
		this.religiousAffliations = religiousAffliations;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public Integer getStaffSize() {
		return staffSize;
	}

	public void setStaffSize(Integer staffSize) {
		this.staffSize = staffSize;
	}

	public List<OrganizationPolicies> getOrganizationConstraints() {
		return organizationConstraints;
	}

	public void setOrganizationConstraints(List<OrganizationPolicies> organizationConstraints) {
		this.organizationConstraints = organizationConstraints;
	}

}
