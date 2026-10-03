package com.karur.mcp_site_management_server.mvpTool;

import com.karur.mcp_site_management_server.entity.SiteEntity;
import com.karur.mcp_site_management_server.mapper.EntityToResponseMapper;
import com.karur.mcp_site_management_server.model.request.SiteRequest;
import com.karur.mcp_site_management_server.model.response.SiteResponse;
import com.karur.mcp_site_management_server.service.SiteService;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.context.McpAsyncRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class SiteMcpTool {

    @Autowired
    SiteService siteService;

    @McpTool(name = "create-site", description = "Add nrw site")
    public Mono<SiteResponse> createSite(McpAsyncRequestContext mcpAsyncRequestContext, SiteRequest siteRequest) {
        return siteService.create(siteRequest);
    }

    @McpTool(name = "fetch-site-by-idetifier")
    public Mono<SiteResponse> createSiteByIdentifier(McpAsyncRequestContext mcpAsyncRequestContext, SiteRequest siteRequest) {
        Optional<SiteEntity> siteEntity = siteService.findSiteEntityByIdentifier(siteRequest.getIdentifier());
        return Mono.defer(() -> Mono.just(EntityToResponseMapper.buildSiteResponse(siteEntity.get())));
    }
}
