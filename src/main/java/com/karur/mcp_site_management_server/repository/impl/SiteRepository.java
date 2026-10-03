package com.karur.mcp_site_management_server.repository.impl;

import com.karur.mcp_site_management_server.entity.SiteEntity;
import com.karur.mcp_site_management_server.repository.intrf.ISiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SiteRepository {

    @Autowired
    ISiteRepository iSiteRepository;

    public Optional<SiteEntity> findByIdentifier(String identifier){
        return iSiteRepository.findByIdentifier(identifier);
    }
}
