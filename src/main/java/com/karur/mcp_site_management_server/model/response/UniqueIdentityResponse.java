package com.karur.mcp_site_management_server.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor
public class UniqueIdentityResponse {
    private Long id;
    private String uniqueIdentity;
    private String uniqueIdentityValue;
}
