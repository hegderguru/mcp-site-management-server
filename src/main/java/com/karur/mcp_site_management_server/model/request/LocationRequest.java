package com.karur.mcp_site_management_server.model.request;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {
    private Long id;
    private Long longitude;
    private Long latitude;
    private String border;
}
