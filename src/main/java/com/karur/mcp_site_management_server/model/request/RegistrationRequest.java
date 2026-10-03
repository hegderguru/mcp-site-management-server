package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    private Long id;
    @DiffId
    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<OwnerRequest> currentOwnerRequests;
    private List<SiteRequest> siteRequests;
}

