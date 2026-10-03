package com.karur.mcp_site_management_server.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_address_id", referencedColumnName = "id")
    private AddressEntity primaryAddressEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "permanent_address_id", referencedColumnName = "id")
    private AddressEntity permanentAddressEntity;
    private Integer order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identity_id", referencedColumnName = "id")
    private IdentityEntity identityEntity;
}
