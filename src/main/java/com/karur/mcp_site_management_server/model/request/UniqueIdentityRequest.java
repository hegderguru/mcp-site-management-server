package com.karur.mcp_site_management_server.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor
public class UniqueIdentityRequest {
    private Long id;

    private String uniqueIdentity;

    private String uniqueIdentityValue;
}
