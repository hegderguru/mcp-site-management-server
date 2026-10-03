package com.karur.mcp_site_management_server.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteResponse {
    private Long id;
    private String identifier;
    private String number;
    private String name;
    private LocationResponse locationResponse;
    private AddressResponse addressResponse;
    private List<OwnerResponse> ownersResponse;
    private RegistrationResponse currentRegistrationResponse;
    private List<RegistrationResponse> previousRegistrationResponses;
}