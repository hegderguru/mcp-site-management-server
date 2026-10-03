package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.entity.Registration;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocationRequest location;
    private AddressRequest address;
    private List<OwnerRequest> owners;
    private RegistrationRequest currentRegistrationRequest;
}