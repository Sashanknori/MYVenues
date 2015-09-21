CREATE TABLE MYVENUES.CUSTOMER_IDENTIFIER (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
CUSTOMER_NAME_REF_NUM INT NOT NULL,
CUSTOMER_ADDRESS_REF_NUM INT NOT NULL,
CUSTOMER_EMAIL_REF_NUM INT NOT NULL,
CUSTOMER_PHONE_REF_NUM INT NOT NULL,
CUSTOMER_CREATE_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
CUSTOMER_SUBSCRIPTION_STATUS VARCHAR(1) NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_TYPE)
);

CREATE TABLE MYVENUES.ORGANIZATION_DETAILS (
ORGANIZATION_ID VARCHAR(10) NOT NULL,
ORGANIZATION_TYPE VARCHAR(1) NOT NULL,
SEATING_CAPACITY INT NOT NULL,
NUMBER_OF_HALLS INT DEFAULT 1 NOT NULL,
NUMBER_OF_AC_ROOMS INT DEFAULT 0 NOT NULL,
NUMBER_OF_NON_AC_ROOMS INT DEFAULT 0 NOT NULL,
PARKING_CAPACITY INT DEFAULT 0 NOT NULL,
STAFF_SIZE INT DEFAULT 0 NOT NULL,
IS_AIR_CONDITIONED_FLAG VARCHAR(1) DEFAULT 'N' NOT NULL,
RELIGIOUS_AFFLIATIONS VARCHAR(50) NOT NULL,
HAS_POWER_BACK_UP VARCHAR(1) DEFAULT 'N' NOT NULL,
DINING_FACILITY INT DEFAULT 0 NOT NULL,
HAS_DECORATOR VARCHAR(1) DEFAULT 'N' NOT NULL,
HAS_LIGHTING_OPTION VARCHAR(1) DEFAULT 'N' NOT NULL,
HAS_SOUND_OPTION VARCHAR(1) DEFAULT 'N' NOT NULL,
ORGANIZATION_ESTD_DATE DATE NOT NULL,
NON_VEG_ALLOWED_FLAG VARCHAR(1) DEFAULT 'N' NOT NULL,
LIQUOR_ALLOWED VARCHAR(1) DEFAULT 'N' NOT NULL,
LAST_MODIFIED TIMESTAMP NOT NULL,
PRIMARY KEY (ORGANIZATION_ID)
);

CREATE TABLE MYVENUES.ORGANIZATION_MAPPER (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
ORGANIZATION_ID VARCHAR(10) NOT NULL,
ORGANIZATION_NAME_REF_NUM INT NOT NULL,
ORGANIZATION_ADDRESS_REF_NUM INT NOT NULL,
ORGANIZATION_EMAIL_REF_NUM INT NOT NULL,
ORGANIZATION_PHONE_REF_NUMBER INT NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL,
LAST_MODIFIED_DATE TIMESTAMP NOT NULL,
ORGANIZATION_SUBSCRIPTION_STATUS VARCHAR(1) NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_TYPE,ORGANIZATION_ID)
);

CREATE TABLE MYVENUES.CUSTOMER_NAME_DETAILS (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
CUSTOMER_NAME_REF_NUM INT NOT NULL,
FIRST_NAME VARCHAR(50) NOT NULL,
LAST_NAME VARCHAR(50),
MIDDLE_NAME VARCHAR(40),
SUFFIX VARCHAR(20),
PREFERRED_NAME_FLAG VARCHAR(1) NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_NAME_REF_NUM,CUSTOMER_TYPE)
);

CREATE TABLE MYVENUES.EVENT_SUPPORT_DETAILS (
ORGANIZATION_ID VARCHAR(10) NOT NULL,
EVENT_SEQ_NUM INT NOT NULL,
EVENT_NAME VARCHAR(15) NOT NULL,
EVENT_ALLOWED_INDICATOR VARCHAR(1) DEFAULT 'Y' NOT NULL,
LAST_MODIFIED TIMESTAMP NOT NULL,
PRIMARY KEY (ORGANIZATION_ID,EVENT_SEQ_NUM)
);

CREATE TABLE MYVENUES.ORGANIZATION_FAQ (
ORGANIZATION_ID VARCHAR(10) NOT NULL,
QUESTION_ID INT NOT NULL,
QUESTION VARCHAR(255) NOT NULL,
ANSWER VARCHAR(255) NOT NULL,
LAST_MODIFIED TIMESTAMP NOT NULL,
PRIMARY KEY (ORGANIZATION_ID,QUESTION_ID)
);

CREATE TABLE MYVENUES.CUSTOMER_ALERTS (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(1) NOT NULL,
DO_SEND_SMS_ALERTS VARCHAR(1) DEFAULT 'Y' NOT NULL,
DO_SEND_MAIL_ALERTS VARCHAR(1) DEFAULT 'Y' NOT NULL,
LAST_ALERT_SENT TIMESTAMP NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_TYPE)
);

CREATE TABLE MYVENUES.CUSTOMER_EMAIL (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
CUSTOMER_EMAIL_REF_NUM INT NOT NULL,
EMAIL_ID VARCHAR(100) NOT NULL,
PREFERRED_EMAILID_FLAG VARCHAR(1) NOT NULL,
EMAIL_TYPE VARCHAR(1) NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_EMAIL_REF_NUM,CUSTOMER_TYPE)
);

CREATE TABLE MYVENUES.ORGANIZATION_IMAGES (
ORGANIZATION_ID VARCHAR(10) NOT NULL,
IMAGE_SEQ_ID INT NOT NULL,
IMAGE BLOB NOT NULL,
LAST_MODIFIED TIMESTAMP NOT NULL,
ACTIVE_IMAGE VARCHAR(1) DEFAULT 'Y' NOT NULL,
PRIMARY KEY (ORGANIZATION_ID,IMAGE_SEQ_ID)
);

CREATE TABLE MYVENUES.ORGANIZATION_AVAILABILITY (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
ORGANIZATION_ID VARCHAR(10) NOT NULL,
BOOKED_STRT_DATE TIMESTAMP NOT NULL,
BOOKING_END_DATE TIMESTAMP NOT NULL,
BOOKING_SEQ_NUM INT,
LAST_MODIFIED TIMESTAMP NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_TYPE,ORGANIZATION_ID)
);

CREATE TABLE MYVENUES.CUSTOMER_PHONE (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
CUSTOMER_PHONE_REF_NUM INT NOT NULL,
COUNTRY_CODE VARCHAR(3) NOT NULL,
PHONE_NUMBER VARCHAR(1) NOT NULL,
PHONE_TYPE VARCHAR(1) NOT NULL,
PREFERRED_PHONE_FLAG VARCHAR(1) NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_TYPE,CUSTOMER_PHONE_REF_NUM)
);


CREATE TABLE MYVENUES.ORGANIZATION_CONSTRAINTS (
ORGANIZATION_ID VARCHAR(10) NOT NULL,
CONSTRAINT_ID INT NOT NULL,
CONSTRAINT_TYPE VARCHAR(255),
CONSTRAINT_DESCRIPTION VARCHAR(255) NOT NULL,
IS_ACTIVE_CONSTRAINT VARCHAR(1) DEFAULT 'Y',
LAST_MODIFIED TIMESTAMP NOT NULL,
PRIMARY KEY (ORGANIZATION_ID,CONSTRAINT_ID)
);


CREATE TABLE MYVENUES.CUSTOMER_ADDRESS (
CUSTOMER_ID VARCHAR(15) NOT NULL,
CUSTOMER_TYPE VARCHAR(5) NOT NULL,
CUSTOMER_ADDRESS_REF_NUM INT NOT NULL,
HOUSE_NUMBER VARCHAR(50) NOT NULL,
APPT_NO VARCHAR(10),
STREET VARCHAR(50),
CITY VARCHAR(20),
STATE VARCHAR(20) NOT NULL,
COUNTRY VARCHAR(20) DEFAULT 'INDIA' NOT NULL,
ADDRESS_TYPE VARCHAR(1) NOT NULL,
PREFERRED_ADDRESS_FLAG VARCHAR(1) NOT NULL,
CREATE_DATE TIMESTAMP NOT NULL,
PRIMARY KEY (CUSTOMER_ID,CUSTOMER_ADDRESS_REF_NUM,CUSTOMER_TYPE)
);



ALTER TABLE MYVENUES.ORGANIZATION_IMAGES ADD CONSTRAINT ORGANIZATION_IMAGES_ORGANIZATION_DETAILS_FK FOREIGN KEY (ORGANIZATION_ID)
REFERENCES MYVENUES.ORGANIZATION_DETAILS (ORGANIZATION_ID)
ON DELETE CASCADE;
ALTER TABLE MYVENUES.ORGANIZATION_CONSTRAINTS ADD CONSTRAINT ORGANIZATION_CONSTRAINTS_ORGANIZATION_DETAILS_FK FOREIGN KEY (ORGANIZATION_ID)
REFERENCES MYVENUES.ORGANIZATION_DETAILS (ORGANIZATION_ID)
ON DELETE RESTRICT;
ALTER TABLE MYVENUES.CUSTOMER_NAME_DETAILS ADD CONSTRAINT CUSTOMER_NAME_DETAILS_CUSTOMER_IDENTIFIER_FK FOREIGN KEY (CUSTOMER_ID, CUSTOMER_TYPE)
REFERENCES MYVENUES.CUSTOMER_IDENTIFIER (CUSTOMER_ID, CUSTOMER_TYPE)
ON DELETE CASCADE;
ALTER TABLE MYVENUES.CUSTOMER_ADDRESS ADD CONSTRAINT CUSTOMER_ADDRESS_CUSTOMER_IDENTIFIER_FK FOREIGN KEY (CUSTOMER_ID, CUSTOMER_TYPE)
REFERENCES MYVENUES.CUSTOMER_IDENTIFIER (CUSTOMER_ID, CUSTOMER_TYPE)
ON DELETE CASCADE;
ALTER TABLE MYVENUES.ORGANIZATION_MAPPER ADD CONSTRAINT ORGANIZATION_DETAILS_CUSTOMER_IDENTIFIER_FK FOREIGN KEY (CUSTOMER_ID, CUSTOMER_TYPE)
REFERENCES MYVENUES.CUSTOMER_IDENTIFIER (CUSTOMER_ID, CUSTOMER_TYPE)
ON DELETE CASCADE;
ALTER TABLE MYVENUES.CUSTOMER_EMAIL ADD CONSTRAINT CUSTOMER_EMAIL_CUSTOMER_IDENTIFIER_FK FOREIGN KEY (CUSTOMER_ID, CUSTOMER_TYPE)
REFERENCES MYVENUES.CUSTOMER_IDENTIFIER (CUSTOMER_ID, CUSTOMER_TYPE)
ON DELETE CASCADE;
ALTER TABLE MYVENUES.ORGANIZATION_FAQ ADD CONSTRAINT ORGANIZATION_FAQ_ORGANIZATION_DETAILS_FK FOREIGN KEY (ORGANIZATION_ID)
REFERENCES MYVENUES.ORGANIZATION_DETAILS (ORGANIZATION_ID)
ON DELETE RESTRICT;
ALTER TABLE MYVENUES.CUSTOMER_PHONE ADD CONSTRAINT CUSTOMER_PHONE_CUSTOMER_IDENTIFIER_FK FOREIGN KEY (CUSTOMER_ID, CUSTOMER_TYPE)
REFERENCES MYVENUES.CUSTOMER_IDENTIFIER (CUSTOMER_ID, CUSTOMER_TYPE)
ON DELETE CASCADE;
ALTER TABLE MYVENUES.ORGANIZATION_AVAILABILITY ADD CONSTRAINT ORGANIZATION_AVAILABILITY_ORGANIZATION_MAPPER_FK FOREIGN KEY (CUSTOMER_ID, CUSTOMER_TYPE, ORGANIZATION_ID)
REFERENCES MYVENUES.ORGANIZATION_MAPPER (CUSTOMER_ID, CUSTOMER_TYPE, ORGANIZATION_ID)
ON DELETE RESTRICT;


