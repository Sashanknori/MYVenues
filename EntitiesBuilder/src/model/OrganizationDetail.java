package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ORGANIZATION_DETAILS database table.
 * 
 */
@Entity
@Table(name="ORGANIZATION_DETAILS")
@NamedQuery(name="OrganizationDetail.findAll", query="SELECT o FROM OrganizationDetail o")
public class OrganizationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORGANIZATION_ID", unique=true, nullable=false, length=10)
	private String organizationId;

	@Column(name="DINING_FACILITY", nullable=false)
	private int diningFacility;

	@Column(name="HAS_DECORATOR", nullable=false, length=1)
	private String hasDecorator;

	@Column(name="HAS_LIGHTING_OPTION", nullable=false, length=1)
	private String hasLightingOption;

	@Column(name="HAS_POWER_BACK_UP", nullable=false, length=1)
	private String hasPowerBackUp;

	@Column(name="HAS_SOUND_OPTION", nullable=false, length=1)
	private String hasSoundOption;

	@Column(name="IS_AIR_CONDITIONED_FLAG", nullable=false, length=1)
	private String isAirConditionedFlag;

	@Column(name="LAST_MODIFIED", nullable=false)
	private Timestamp lastModified;

	@Column(name="LIQUOR_ALLOWED", nullable=false, length=1)
	private String liquorAllowed;

	@Column(name="NON_VEG_ALLOWED_FLAG", nullable=false, length=1)
	private String nonVegAllowedFlag;

	@Column(name="NUMBER_OF_AC_ROOMS", nullable=false)
	private int numberOfAcRooms;

	@Column(name="NUMBER_OF_HALLS", nullable=false)
	private int numberOfHalls;

	@Column(name="NUMBER_OF_NON_AC_ROOMS", nullable=false)
	private int numberOfNonAcRooms;

	@Temporal(TemporalType.DATE)
	@Column(name="ORGANIZATION_ESTD_DATE", nullable=false)
	private Date organizationEstdDate;

	@Column(name="ORGANIZATION_TYPE", nullable=false, length=1)
	private String organizationType;

	@Column(name="PARKING_CAPACITY", nullable=false)
	private int parkingCapacity;

	@Column(name="RELIGIOUS_AFFLIATIONS", nullable=false, length=50)
	private String religiousAffliations;

	@Column(name="SEATING_CAPACITY", nullable=false)
	private int seatingCapacity;

	@Column(name="STAFF_SIZE", nullable=false)
	private int staffSize;

	//bi-directional many-to-one association to OrganizationConstraint
	@OneToMany(mappedBy="organizationDetail")
	private List<OrganizationConstraint> organizationConstraints;

	//bi-directional many-to-one association to OrganizationFaq
	@OneToMany(mappedBy="organizationDetail")
	private List<OrganizationFaq> organizationFaqs;

	//bi-directional many-to-one association to OrganizationImage
	@OneToMany(mappedBy="organizationDetail")
	private List<OrganizationImage> organizationImages;

	public OrganizationDetail() {
	}

	public String getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public int getDiningFacility() {
		return this.diningFacility;
	}

	public void setDiningFacility(int diningFacility) {
		this.diningFacility = diningFacility;
	}

	public String getHasDecorator() {
		return this.hasDecorator;
	}

	public void setHasDecorator(String hasDecorator) {
		this.hasDecorator = hasDecorator;
	}

	public String getHasLightingOption() {
		return this.hasLightingOption;
	}

	public void setHasLightingOption(String hasLightingOption) {
		this.hasLightingOption = hasLightingOption;
	}

	public String getHasPowerBackUp() {
		return this.hasPowerBackUp;
	}

	public void setHasPowerBackUp(String hasPowerBackUp) {
		this.hasPowerBackUp = hasPowerBackUp;
	}

	public String getHasSoundOption() {
		return this.hasSoundOption;
	}

	public void setHasSoundOption(String hasSoundOption) {
		this.hasSoundOption = hasSoundOption;
	}

	public String getIsAirConditionedFlag() {
		return this.isAirConditionedFlag;
	}

	public void setIsAirConditionedFlag(String isAirConditionedFlag) {
		this.isAirConditionedFlag = isAirConditionedFlag;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getLiquorAllowed() {
		return this.liquorAllowed;
	}

	public void setLiquorAllowed(String liquorAllowed) {
		this.liquorAllowed = liquorAllowed;
	}

	public String getNonVegAllowedFlag() {
		return this.nonVegAllowedFlag;
	}

	public void setNonVegAllowedFlag(String nonVegAllowedFlag) {
		this.nonVegAllowedFlag = nonVegAllowedFlag;
	}

	public int getNumberOfAcRooms() {
		return this.numberOfAcRooms;
	}

	public void setNumberOfAcRooms(int numberOfAcRooms) {
		this.numberOfAcRooms = numberOfAcRooms;
	}

	public int getNumberOfHalls() {
		return this.numberOfHalls;
	}

	public void setNumberOfHalls(int numberOfHalls) {
		this.numberOfHalls = numberOfHalls;
	}

	public int getNumberOfNonAcRooms() {
		return this.numberOfNonAcRooms;
	}

	public void setNumberOfNonAcRooms(int numberOfNonAcRooms) {
		this.numberOfNonAcRooms = numberOfNonAcRooms;
	}

	public Date getOrganizationEstdDate() {
		return this.organizationEstdDate;
	}

	public void setOrganizationEstdDate(Date organizationEstdDate) {
		this.organizationEstdDate = organizationEstdDate;
	}

	public String getOrganizationType() {
		return this.organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public int getParkingCapacity() {
		return this.parkingCapacity;
	}

	public void setParkingCapacity(int parkingCapacity) {
		this.parkingCapacity = parkingCapacity;
	}

	public String getReligiousAffliations() {
		return this.religiousAffliations;
	}

	public void setReligiousAffliations(String religiousAffliations) {
		this.religiousAffliations = religiousAffliations;
	}

	public int getSeatingCapacity() {
		return this.seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public int getStaffSize() {
		return this.staffSize;
	}

	public void setStaffSize(int staffSize) {
		this.staffSize = staffSize;
	}

	public List<OrganizationConstraint> getOrganizationConstraints() {
		return this.organizationConstraints;
	}

	public void setOrganizationConstraints(List<OrganizationConstraint> organizationConstraints) {
		this.organizationConstraints = organizationConstraints;
	}

	public OrganizationConstraint addOrganizationConstraint(OrganizationConstraint organizationConstraint) {
		getOrganizationConstraints().add(organizationConstraint);
		organizationConstraint.setOrganizationDetail(this);

		return organizationConstraint;
	}

	public OrganizationConstraint removeOrganizationConstraint(OrganizationConstraint organizationConstraint) {
		getOrganizationConstraints().remove(organizationConstraint);
		organizationConstraint.setOrganizationDetail(null);

		return organizationConstraint;
	}

	public List<OrganizationFaq> getOrganizationFaqs() {
		return this.organizationFaqs;
	}

	public void setOrganizationFaqs(List<OrganizationFaq> organizationFaqs) {
		this.organizationFaqs = organizationFaqs;
	}

	public OrganizationFaq addOrganizationFaq(OrganizationFaq organizationFaq) {
		getOrganizationFaqs().add(organizationFaq);
		organizationFaq.setOrganizationDetail(this);

		return organizationFaq;
	}

	public OrganizationFaq removeOrganizationFaq(OrganizationFaq organizationFaq) {
		getOrganizationFaqs().remove(organizationFaq);
		organizationFaq.setOrganizationDetail(null);

		return organizationFaq;
	}

	public List<OrganizationImage> getOrganizationImages() {
		return this.organizationImages;
	}

	public void setOrganizationImages(List<OrganizationImage> organizationImages) {
		this.organizationImages = organizationImages;
	}

	public OrganizationImage addOrganizationImage(OrganizationImage organizationImage) {
		getOrganizationImages().add(organizationImage);
		organizationImage.setOrganizationDetail(this);

		return organizationImage;
	}

	public OrganizationImage removeOrganizationImage(OrganizationImage organizationImage) {
		getOrganizationImages().remove(organizationImage);
		organizationImage.setOrganizationDetail(null);

		return organizationImage;
	}

}