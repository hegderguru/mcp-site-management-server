package com.karur.mcp_site_management_server.entity;

import com.karur.mcp_site_management_server.model.UniqueIdentityEnum;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
public class UniqueIdentityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unique_identity_seq_gen")
    @SequenceGenerator(name = "unique_identity_seq_gen", sequenceName = "unique_identity_sequence_id", allocationSize = 1)
    private Long id;

    @Column(name = "owner_id", insertable = false, updatable = false)
    private Long ownerId;

    private UniqueIdentityEnum uniqueIdentityEnum;

    private String uniqueIdentityValue;
}
