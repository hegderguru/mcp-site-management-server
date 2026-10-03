package com.karur.mcp_site_management_server.model.request;

import com.karur.mcp_site_management_server.compare.DiffId;
import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentityRequest {

    @DiffId
    private Long id;
    private String aadhar;
    private String panCard;
    private String idName;
    private String idValue;
}
