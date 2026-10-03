package com.karur.mcp_site_management_server.model.response;

import java.time.LocalDateTime;
import java.util.List;

public class RegistrationResponse {
    private Long id;
    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<OwnerResponse> previousOwners;
    private List<OwnerResponse> currentOwners;
}

