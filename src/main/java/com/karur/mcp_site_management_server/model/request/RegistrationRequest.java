package com.karur.mcp_site_management_server.model.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private Long id;


    private String identifier;


    private LocalDateTime registrationDateTime;


    private List<OwnerRequest> currentOwnerRequests;


    private List<SiteRequest> siteRequests;
}

