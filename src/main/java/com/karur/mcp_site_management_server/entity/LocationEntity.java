package com.karur.mcp_site_management_server.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq_gen")
    @SequenceGenerator(name = "location_seq_gen", sequenceName = "location_sequence_id", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String longitudeAndLatitude;

    @Column(columnDefinition = "TEXT")
    private String border;
}
