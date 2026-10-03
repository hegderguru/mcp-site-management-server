package com.karur.mcp_site_management_server.entity;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site {
    private Long id;

    @EqualsAndHashCode.Include
    private String identifier;

    private String number;
    private String name;
    private Location location;
    private Address address;
    private List<Owner> owners;
    private Registration currentRegistration;
    private List<Registration> allRegistrations;
}
