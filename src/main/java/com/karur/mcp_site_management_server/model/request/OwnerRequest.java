package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.entity.IdentityEntity;
import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
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

    @EqualsAndHashCode.Include
    private IdentityEntity identityEntity;
}
