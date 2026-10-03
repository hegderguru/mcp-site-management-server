package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import com.karur.mcp_site_management_server.entity.IdentityEntity;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {

    private Long id;
    @DiffId
    private String firstName;
    @DiffId
    private String middleName;
    @DiffId
    private String lastName;
    private AddressRequest primaryAddress;
    private AddressRequest PermanentAddress;
    private Integer order;

    private IdentityRequest identityRequest;
}
