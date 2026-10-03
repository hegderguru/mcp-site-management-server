package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import com.karur.mcp_site_management_server.entity.IdentityEntity;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {

    @DiffId
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private AddressRequest primaryAddress;
    private AddressRequest PermanentAddress;
    private Integer order;


    private IdentityEntity identityEntity;
}
