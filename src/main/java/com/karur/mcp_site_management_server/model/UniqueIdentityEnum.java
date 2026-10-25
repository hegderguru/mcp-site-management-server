package com.karur.mcp_site_management_server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UniqueIdentityEnum {

    AADHAR("Aadhar"),
    PANACRD("Pan Card");

    String identity;
}
