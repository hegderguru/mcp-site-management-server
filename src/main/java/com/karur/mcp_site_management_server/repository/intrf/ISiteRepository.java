package com.karur.mcp_site_management_server.repository.intrf;

import com.karur.mcp_site_management_server.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISiteRepository extends JpaRepository<SiteEntity, Long> {
    Optional<SiteEntity> findByIdentifier(String identifier);
}
