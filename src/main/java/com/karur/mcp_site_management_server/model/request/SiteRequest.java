package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import lombok.*;

import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteRequest {

    private Long id;

    @DiffId
    private String identifier;

    private String number;
    private String name;
    private LocationRequest locationRequest;
    private AddressRequest addressRequest;
    private RegistrationRequest currentRegistrationRequest;
}