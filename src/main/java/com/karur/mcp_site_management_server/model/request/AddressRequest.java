package com.karur.mcp_site_management_server.model.request;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private Long id;

    @EqualsAndHashCode.Include
    private String number;

    private String name;

    @EqualsAndHashCode.Include
    private String floor;

    @EqualsAndHashCode.Include
    private String street;

    @EqualsAndHashCode.Include
    private String place;

    @EqualsAndHashCode.Include
    private String city;

    @EqualsAndHashCode.Include
    private String state;

    @EqualsAndHashCode.Include
    private String country;

    @EqualsAndHashCode.Include
    private String pinCode;

}
