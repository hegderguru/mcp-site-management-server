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
    @SequenceGenerator(name = "owner_seq_gen", sequenceName = "owner_sequence_id", allocationSize = 1)
    private Long id;

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    @Column(insertable = true, updatable = false)
    private String aadhar;

    @Column(insertable = true, updatable = false)
    private String panCard;

    @Column(insertable = true, updatable = false)
    private String idNameAndValue;

    @Column(insertable = true, updatable = false)
    private String orgRegNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "primary_address_id")
    private AddressEntity primaryAddressEntity;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "permanent_address_id")
    private AddressEntity permanentAddressEntity;

    @Column(name = "owner_order")
    private Integer order;
}
