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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "registration_current_owners",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id")
    )
    private List<OwnerEntity> currentOwnerEntities;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "registration_sites",
            joinColumns = @JoinColumn(name = "registration_id"),
            inverseJoinColumns = @JoinColumn(name = "site_id")
    )
    private List<SiteEntity> siteEntities;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "registration_id")
    private List<RegistrationAuditEntity> registrationAuditEntities;
}
