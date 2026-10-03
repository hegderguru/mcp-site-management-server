package com.karur.mcp_site_management_server.entity;

import lombok.*;

import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
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
