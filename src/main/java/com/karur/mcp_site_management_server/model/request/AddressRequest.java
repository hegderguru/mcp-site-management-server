package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @DiffId
    private Long id;

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
