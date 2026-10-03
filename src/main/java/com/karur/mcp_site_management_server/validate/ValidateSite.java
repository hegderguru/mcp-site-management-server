package com.karur.mcp_site_management_server.validate;

import com.karur.mcp_site_management_server.model.request.SiteRequest;
import com.karur.mcp_site_management_server.repository.impl.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateSite {

    @Autowired
    SiteRepository siteRepository;

    public void validate(SiteRequest siteRequest){
        
    }

}
