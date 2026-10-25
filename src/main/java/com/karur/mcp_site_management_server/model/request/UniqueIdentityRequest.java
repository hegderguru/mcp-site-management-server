package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor
public class UniqueIdentityRequest {
    private Long id;

    @DiffId
    private String uniqueIdentity;

    private String uniqueIdentityValue;
}
