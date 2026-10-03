package com.karur.mcp_site_management_server.model.request;

import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentityRequest {
    private Long id;

    @EqualsAndHashCode.Include
    private String aadhar;

    @EqualsAndHashCode.Include
    private String panCard;

    private String idName;
    private String idValue;
}
