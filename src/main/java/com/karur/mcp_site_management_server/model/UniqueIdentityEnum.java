package com.karur.mcp_site_management_server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UniqueIdentityEnum {

    AADHAR_CARD("Aadhar Card"),
    PAN_CARD("Pan Card"),
    ORG_NUMBER("Organisation Number");

    String identity;
}
