package com.karur.mcp_site_management_server.model.request;

import lombok.*;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteRequest {

    private Long id;


    private String identifier;
    private String number;
    private String name;
    private LocationRequest locationRequest;
    private AddressRequest addressRequest;
    private List<OwnerRequest> ownersRequests;
    private RegistrationRequest currentRegistrationRequest;
}