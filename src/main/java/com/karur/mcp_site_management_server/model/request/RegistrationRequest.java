package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.entity.Owner;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
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

