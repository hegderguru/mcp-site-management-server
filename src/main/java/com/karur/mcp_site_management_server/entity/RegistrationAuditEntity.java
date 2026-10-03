package com.karur.mcp_site_management_server.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "registration_audit")
public class RegistrationAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_audit_seq_gen")
    @SequenceGenerator(name = "registration_audit_seq_gen", sequenceName = "registration_audit_sequence", allocationSize = 1)
    private Long id;

    private String identifier;
    private LocalDateTime registrationDateTime;

    // Owning side (defines the join table)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "registration_audit_sites",
            joinColumns = @JoinColumn(name = "audit_id"),
            inverseJoinColumns = @JoinColumn(name = "site_id")
    )
    private List<SiteEntity> siteEntities;

    // Owning side (defines the join table)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "registration_audit_owners",
            joinColumns = @JoinColumn(name = "audit_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<OwnerEntity> previousOwnerEntities;

    // Bidirectional back-link to parent RegistrationEntity (Owning column)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_id")
    private RegistrationEntity registration;
}
