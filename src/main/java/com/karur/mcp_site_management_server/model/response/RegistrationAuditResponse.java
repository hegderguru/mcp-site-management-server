package com.karur.mcp_site_management_server.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationAuditResponse {
    private Long id;
    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<SiteResponse> siteResponses;
    private List<OwnerResponse> previousOwnerResponses;
}
