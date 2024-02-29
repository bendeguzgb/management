-- DROP TABLE management.dbo.address;

CREATE TABLE management.dbo.address (
	id bigint NOT NULL,
	house_number varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	street varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	town varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__address__3213E83F75644931 PRIMARY KEY (id)
);

-------------------------------------------------------------------

-- DROP TABLE management.dbo.contact;

CREATE TABLE management.dbo.contact (
	id bigint NOT NULL,
	email varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	phone_number varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__contact__3213E83FB5066A71 PRIMARY KEY (id)
);

-------------------------------------------------------------------

-- DROP TABLE management.dbo.address_contacts;

CREATE TABLE management.dbo.address_contacts (
	address_id bigint NOT NULL,
	contacts_id bigint NOT NULL,
	CONSTRAINT UK_5xeh307lscc280k79rbdrve6w UNIQUE (contacts_id),
	CONSTRAINT FKowtqkfx31kuatv1v7cal5yrx FOREIGN KEY (contacts_id) REFERENCES management.dbo.contact(id),
	CONSTRAINT FKr8g9gecmhmtcyqxbtrejqw42d FOREIGN KEY (address_id) REFERENCES management.dbo.address(id)
);

-------------------------------------------------------------------

-- DROP TABLE management.dbo.person;

CREATE TABLE management.dbo.person (
	id bigint NOT NULL,
	permanent_address_id bigint NULL,
	temporary_address_id bigint NULL,
	full_name varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	CONSTRAINT PK__person__3213E83FABFBC3FD PRIMARY KEY (id),
	CONSTRAINT FKjnq0mw388ehmkcwip9f3ecedi FOREIGN KEY (permanent_address_id) REFERENCES management.dbo.address(id),
	CONSTRAINT FKput4er121vdnjoqfdwxlg0085 FOREIGN KEY (temporary_address_id) REFERENCES management.dbo.address(id)
);

CREATE sequence address_seq start WITH 1 increment BY 1;
CREATE sequence contact_seq start WITH 1 increment BY 1;
CREATE sequence person_seq start WITH 1 increment BY 1;