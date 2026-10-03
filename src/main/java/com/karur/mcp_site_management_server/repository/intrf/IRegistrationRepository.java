package com.karur.mcp_site_management_server.repository.intrf;

import com.karur.mcp_site_management_server.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
}
