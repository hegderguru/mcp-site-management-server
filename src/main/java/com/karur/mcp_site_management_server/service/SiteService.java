package com.karur.mcp_site_management_server.service;

import com.karur.mcp_site_management_server.compare.CompareUtil;
import com.karur.mcp_site_management_server.entity.SiteEntity;
import com.karur.mcp_site_management_server.mapper.EntityToRequestMapper;
import com.karur.mcp_site_management_server.mapper.EntityToResponseMapper;
import com.karur.mcp_site_management_server.mapper.RequestToEntityMapper;
import com.karur.mcp_site_management_server.model.request.SiteRequest;
import com.karur.mcp_site_management_server.model.response.SiteResponse;
import com.karur.mcp_site_management_server.repository.impl.SiteRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
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

    public Mono<SiteResponse> create(SiteRequest siteRequest) {
        SiteEntity siteEntity = RequestToEntityMapper.buildCompleteSite(siteRequest);
        return Mono.defer(() -> Mono.just(EntityToResponseMapper.buildSiteResponse(siteEntity)));
    }
}
