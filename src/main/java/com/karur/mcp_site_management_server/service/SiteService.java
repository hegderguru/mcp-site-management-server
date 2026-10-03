package com.karur.mcp_site_management_server.service;

import com.karur.mcp_site_management_server.entity.SiteEntity;
import com.karur.mcp_site_management_server.model.request.SiteRequest;
import com.karur.mcp_site_management_server.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;
import java.util.Optional;

public class SiteService {

    @Autowired
    SiteRepository siteRepository;
    
    public Optional<SiteEntity> findSiteEntityByIdentifier(String identifier){
        return siteRepository.findByIdentifier(identifier);
    }

    public void update(SiteRequest siteRequest){
        if(Objects.isNull(siteRequest)){
            throw new IllegalArgumentException("Invalid request");
        }
        Optional<SiteEntity> siteEntityOptional = findSiteEntityByIdentifier(siteRequest.getIdentifier());
        if(siteEntityOptional.isEmpty()){
            createSite(siteRequest);
        }
        else {
            updateSite(siteRequest,siteEntityOptional.get());
        }
    }

    private void updateSite(SiteRequest siteRequest, SiteEntity siteEntity) {
    }

    private void createSite(SiteRequest siteRequest) {
    }
}
