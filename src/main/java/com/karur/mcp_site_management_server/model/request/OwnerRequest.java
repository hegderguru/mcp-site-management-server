package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;


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
    private String email;
    private String phone;

    private List<UniqueIdentityRequest> uniqueIdentityRequests;
    private String orgRegNumber;

    private AddressRequest primaryAddress;
    private AddressRequest PermanentAddress;
    private Integer order;
}
