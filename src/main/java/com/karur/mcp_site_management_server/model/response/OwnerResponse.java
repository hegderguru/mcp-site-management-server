package com.karur.mcp_site_management_server.model.response;

import com.karur.mcp_site_management_server.entity.IdentityEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerResponse {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private AddressResponse primaryAddress;
    private AddressResponse PermanentAddress;
    private Integer order;
    private IdentityEntity identityEntity;

}
