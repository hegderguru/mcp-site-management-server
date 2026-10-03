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
public class SiteRequestResponse {
    private Long id;
    private String identifier;
    private String number;
    private String name;
    private LocationResponse location;
    private AddressResponse address;
    private List<OwnerResponse> owners;
    private RegistrationResponse currentRegistrationResponse;
    private List<RegistrationResponse> previousRegistrationResponses;
}