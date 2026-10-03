package com.karur.mcp_site_management_server.entity;

import com.karur.mcp_site_management_server.model.request.OwnerRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Registration {
    private Long id;

    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<Owner> previousOwners;
    private List<Owner> currentOwners;
}
