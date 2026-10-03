package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import jakarta.persistence.Column;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private Long id;

    @DiffId
    private String number;
    private String name;
    private String floor;
    private String street;
    private String place;
    private String city;
    private String state;
    private String country;
    private String pinCode;

}
