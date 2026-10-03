package com.karur.mcp_site_management_server.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    private Long id;
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
