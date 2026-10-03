package com.karur.mcp_site_management_server.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "identity")
public class IdentityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_seq_gen")
    @SequenceGenerator(name = "identity_seq_gen", sequenceName = "identity_sequence", allocationSize = 1)
    private Long id;

    private String aadhar;
    private String panCard;
    private String idName;
    private String idValue;
}
