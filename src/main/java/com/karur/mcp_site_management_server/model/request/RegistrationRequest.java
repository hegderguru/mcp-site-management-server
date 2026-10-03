package com.karur.mcp_site_management_server.model.request;

import java.time.LocalDateTime;
import java.util.List;

public class RegistrationRequest {
    private Long id;
    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<OwnerRequest> previousOwners;
    private List<OwnerRequest> currentOwners;
}

