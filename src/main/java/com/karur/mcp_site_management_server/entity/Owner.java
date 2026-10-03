package com.karur.mcp_site_management_server.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Address primaryAddress;
    private Address PermanentAddress;
    private Integer order;
}
