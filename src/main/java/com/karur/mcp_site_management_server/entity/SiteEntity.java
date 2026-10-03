package com.karur.mcp_site_management_server.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "site")
public class SiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "site_seq_gen")
    @SequenceGenerator(name = "site_seq_gen", sequenceName = "site_sequence", allocationSize = 1)
    private Long id;

    private String identifier;
    private String number;
    private String name;

    // Owning side (holds foreign key column)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "location_id")
    private LocationEntity locationEntity;

    // Owning side (holds foreign key column)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    // Owning side (holds foreign key column)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "current_registration_id")
    private RegistrationEntity currentRegistrationEntity;

    // Inverse side of RegistrationEntity's siteEntities list
    @ManyToMany(mappedBy = "siteEntities")
    private List<RegistrationEntity> registrations;

    // Inverse side of RegistrationAuditEntity's siteEntities list
    @ManyToMany(mappedBy = "siteEntities")
    private List<RegistrationAuditEntity> registrationAudits;
}
