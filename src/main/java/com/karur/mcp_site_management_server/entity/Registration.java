package com.karur.mcp_site_management_server.entity;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

public class Registration {
    private Long id;

    @EqualsAndHashCode.Include
    private String identifier;

    @EqualsAndHashCode.Include
    private LocalDateTime registrationDateTime;

    @EqualsAndHashCode.Include
    private List<Owner> previousOwners;

    @EqualsAndHashCode.Include
    private List<Owner> currentOwners;
}
