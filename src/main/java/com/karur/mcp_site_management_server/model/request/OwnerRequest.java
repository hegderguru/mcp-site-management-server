package com.karur.mcp_site_management_server.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private AddressRequest primaryAddress;
    private AddressRequest PermanentAddress;
    private Integer order;
}
