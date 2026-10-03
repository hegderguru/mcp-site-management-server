package com.karur.mcp_site_management_server.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Registration {
    private Long id;
    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<Owner> previousOwners;
    private List<Owner> currentOwners;
}
