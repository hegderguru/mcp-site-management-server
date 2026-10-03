package com.karur.mcp_site_management_server.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq_gen")
    @SequenceGenerator(name = "owner_seq_gen", sequenceName = "owner_sequence", allocationSize = 1)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;

    // Owning side (holds foreign key column)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "primary_address_id")
    private AddressEntity primaryAddressEntity;

    // Owning side (holds foreign key column)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "permanent_address_id")
    private AddressEntity permanentAddressEntity;

    private Integer order;

    // Owning side (holds foreign key column)
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "identity_id")
    private IdentityEntity identityEntity;

    // Inverse side of RegistrationEntity's currentOwnerEntities list
    @ManyToMany(mappedBy = "currentOwnerEntities")
    private List<RegistrationEntity> registrations;

    // Inverse side of RegistrationAuditEntity's previousOwnerEntities list
    @ManyToMany(mappedBy = "previousOwnerEntities")
    private List<RegistrationAuditEntity> registrationAudits;
}
