package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationRequest {

    @DiffId
    private Long id;
    private Long longitude;
    private Long latitude;
    private String border;
}
