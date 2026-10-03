package com.karur.mcp_site_management_server.model.request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private Long id;

    @EqualsAndHashCode.Include
    private String identifier;

    @EqualsAndHashCode.Include
    private LocalDateTime registrationDateTime;

    @EqualsAndHashCode.Include
    private List<OwnerRequest> currentOwnerRequests;

    @EqualsAndHashCode.Include
    private List<SiteRequest> siteRequests;
}

