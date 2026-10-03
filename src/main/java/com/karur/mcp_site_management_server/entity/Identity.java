package com.karur.mcp_site_management_server.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identity {
    private Long id;

    @EqualsAndHashCode.Include
    private String aadhar;

    @EqualsAndHashCode.Include
    private String panCard;
    
    private String idName;
    private String idValue;
}
