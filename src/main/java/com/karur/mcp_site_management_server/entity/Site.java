package com.karur.mcp_site_management_server.entity;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site {
    private Long id;

    private String identifier;

    private String number;
    private String name;
    private LocationEntity locationEntity;
    private AddressEntity addressEntity;
    private List<OwnerEntity> ownerEntities;
    private RegistrationEntity currentRegistrationEntity;
    private List<RegistrationEntity> allRegistrationEntities;
}
