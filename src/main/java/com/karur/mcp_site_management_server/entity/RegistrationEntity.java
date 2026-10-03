package com.karur.mcp_site_management_server.entity;

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
public class RegistrationEntity {
    private Long id;

    private String identifier;
    private LocalDateTime registrationDateTime;
    private List<OwnerEntity> previousOwnerEntities;
    private List<OwnerEntity> currentOwnerEntities;
}
