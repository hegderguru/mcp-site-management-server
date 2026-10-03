package com.karur.mcp_site_management_server.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerEntity {
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private AddressEntity primaryAddressEntity;
    private AddressEntity permanentAddressEntity;
    private Integer order;
    private IdentityEntity identityEntity;
}
