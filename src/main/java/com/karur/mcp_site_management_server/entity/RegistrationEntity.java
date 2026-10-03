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
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registration_seq_gen")
    @SequenceGenerator(name = "registration_seq_gen", sequenceName = "registration_sequence", allocationSize = 1)
    private Long id;

    private String identifier;
    private LocalDateTime registrationDateTime;

    // Owning side (defines the join table)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "registration_current_owners",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<OwnerEntity> currentOwnerEntities;

    // Owning side (defines the join table)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "registration_sites",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "site_id")
    )
    private List<SiteEntity> siteEntities;

    // Owning side of the OneToMany (points to mappedBy target 'registration' field in child)
    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<RegistrationAuditEntity> registrationAuditEntities;

    // Inverse side of SiteEntity's currentRegistrationEntity mapping
    @OneToOne(mappedBy = "currentRegistrationEntity")
    private SiteEntity activeSite;
}
