package com.karur.mcp_site_management_server.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private Long id;
    private String uniqueIdentifier;
    private String number;
    private String name;
    private String floor;
    private String street;
    private String place;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}
