-- =========================================================================
-- 1. CREATE SEQUENCES
-- =========================================================================
CREATE SEQUENCE address_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE identity_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE location_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE owner_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE site_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE registration_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE registration_audit_sequence START WITH 1 INCREMENT BY 1;

-- =========================================================================
-- 2. CREATE PRIMARY DATA TABLES
-- =========================================================================

CREATE TABLE address (
                         id BIGINT PRIMARY KEY DEFAULT nextval('address_sequence'),
                         number VARCHAR(255),
                         name VARCHAR(255),
                         floor VARCHAR(255),
                         street VARCHAR(255),
                         place VARCHAR(255),
                         city VARCHAR(255),
                         state VARCHAR(255),
                         country VARCHAR(255),
                         pin_code VARCHAR(255)
);

CREATE TABLE identity (
                          id BIGINT PRIMARY KEY DEFAULT nextval('identity_sequence'),
                          aadhar VARCHAR(255),
                          pan_card VARCHAR(255),
                          id_name VARCHAR(255),
                          id_value VARCHAR(255)
);

CREATE TABLE location (
                          id BIGINT PRIMARY KEY DEFAULT nextval('location_sequence'),
                          longitude BIGINT,
                          latitude BIGINT,
                          border TEXT
);

CREATE TABLE owner (
                       id BIGINT PRIMARY KEY DEFAULT nextval('owner_sequence'),
                       first_name VARCHAR(255),
                       middle_name VARCHAR(255),
                       last_name VARCHAR(255),
                       owner_order INT,
                       primary_address_id BIGINT,
                       permanent_address_id BIGINT,
                       identity_id BIGINT,
                       CONSTRAINT fk_owner_primary_address FOREIGN KEY (primary_address_id) REFERENCES address(id) ON DELETE SET NULL,
                       CONSTRAINT fk_owner_permanent_address FOREIGN KEY (permanent_address_id) REFERENCES address(id) ON DELETE SET NULL,
                       CONSTRAINT fk_owner_identity FOREIGN KEY (identity_id) REFERENCES identity(id) ON DELETE SET NULL
);

CREATE TABLE registration (
                              id BIGINT PRIMARY KEY DEFAULT nextval('registration_sequence'),
                              identifier VARCHAR(255),
                              registration_date_time TIMESTAMP
);

CREATE TABLE site (
                      id BIGINT PRIMARY KEY DEFAULT nextval('site_sequence'),
                      identifier VARCHAR(255),
                      number VARCHAR(255),
                      name VARCHAR(255),
                      location_id BIGINT,
                      address_id BIGINT,
                      current_registration_id BIGINT,
                      CONSTRAINT fk_site_location FOREIGN KEY (location_id) REFERENCES location(id) ON DELETE SET NULL,
                      CONSTRAINT fk_site_address FOREIGN KEY (address_id) REFERENCES address(id) ON DELETE SET NULL,
                      CONSTRAINT fk_site_current_registration FOREIGN KEY (current_registration_id) REFERENCES registration(id) ON DELETE SET NULL
);

CREATE TABLE registration_audit (
                                    id BIGINT PRIMARY KEY DEFAULT nextval('registration_audit_sequence'),
                                    identifier VARCHAR(255),
                                    registration_date_time TIMESTAMP,
                                    registration_id BIGINT, -- Handled by unidirectional @OneToMany @JoinColumn
                                    CONSTRAINT fk_audit_registration FOREIGN KEY (registration_id) REFERENCES registration(id) ON DELETE CASCADE
);

-- =========================================================================
-- 3. CREATE @ManyToMany BRIDGE TABLES
-- =========================================================================

-- Registration <-> Current Owners
CREATE TABLE registration_current_owners (
                                             registration_id BIGINT NOT NULL,
                                             owner_id BIGINT NOT NULL,
                                             PRIMARY KEY (registration_id, owner_id),
                                             CONSTRAINT fk_reg_owners_registration FOREIGN KEY (registration_id) REFERENCES registration(id) ON DELETE CASCADE,
                                             CONSTRAINT fk_reg_owners_owner FOREIGN KEY (owner_id) REFERENCES owner(id) ON DELETE CASCADE
);

-- Registration <-> Sites
CREATE TABLE registration_sites (
                                    registration_id BIGINT NOT NULL,
                                    site_id BIGINT NOT NULL,
                                    PRIMARY KEY (registration_id, site_id),
                                    CONSTRAINT fk_reg_sites_registration FOREIGN KEY (registration_id) REFERENCES registration(id) ON DELETE CASCADE,
                                    CONSTRAINT fk_reg_sites_site FOREIGN KEY (site_id) REFERENCES site(id) ON DELETE CASCADE
);

-- Registration Audit <-> Sites
CREATE TABLE registration_audit_sites (
                                          audit_id BIGINT NOT NULL,
                                          site_id BIGINT NOT NULL,
                                          PRIMARY KEY (audit_id, site_id),
                                          CONSTRAINT fk_audit_sites_audit FOREIGN KEY (audit_id) REFERENCES registration_audit(id) ON DELETE CASCADE,
                                          CONSTRAINT fk_audit_sites_site FOREIGN KEY (site_id) REFERENCES site(id) ON DELETE CASCADE
);

-- Registration Audit <-> Previous Owners
CREATE TABLE registration_audit_owners (
                                           audit_id BIGINT NOT NULL,
                                           owner_id BIGINT NOT NULL,
                                           PRIMARY KEY (audit_id, owner_id),
                                           CONSTRAINT fk_audit_owners_audit FOREIGN KEY (audit_id) REFERENCES registration_audit(id) ON DELETE CASCADE,
                                           CONSTRAINT fk_audit_owners_owner FOREIGN KEY (owner_id) REFERENCES owner(id) ON DELETE CASCADE
);
