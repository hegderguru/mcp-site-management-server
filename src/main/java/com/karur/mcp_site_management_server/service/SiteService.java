package com.karur.mcp_site_management_server.service;

import com.karur.mcp_site_management_server.compare.CompareUtil;
import com.karur.mcp_site_management_server.entity.SiteEntity;
import com.karur.mcp_site_management_server.mapper.EntityToRequestMapper;
import com.karur.mcp_site_management_server.model.request.SiteRequest;
import com.karur.mcp_site_management_server.repository.impl.SiteRepository;
import com.karur.mcp_site_management_server.repository.intrf.ISiteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SiteService {

    @Autowired
    SiteRepository siteRepository;
    
    public Optional<SiteEntity> findSiteEntityByIdentifier(String identifier){
        return siteRepository.findByIdentifier(identifier);
    }

    public void update(SiteRequest siteRequest) {
        Optional<SiteEntity> siteEntityOptional = findSiteEntityByIdentifier(siteRequest.getIdentifier());
        if(siteEntityOptional.isPresent()){
            update(siteRequest,siteEntityOptional.get());
        }
        else {
            create(siteRequest);
        }
    }

    private void update(SiteRequest siteRequest,SiteEntity siteEntity) {
        List<CompareUtil.Change> changes = CompareUtil.compare(siteRequest, EntityToRequestMapper.buildSiteRequest(siteEntity));

    }

    private void create(SiteRequest siteRequest) {

    }
}
