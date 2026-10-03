package com.karur.mcp_site_management_server.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentityResponse {
    private Long id;
    private String aadhar;
    private String panCard;
    private String idName;
    private String idValue;
}
