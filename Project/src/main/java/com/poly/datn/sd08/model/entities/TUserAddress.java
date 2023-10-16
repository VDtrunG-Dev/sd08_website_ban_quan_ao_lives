package com.poly.datn.sd08.model.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "t_user_address")
public class TUserAddress {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private TUser customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private TAddress address;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "status")
    private Integer status;

}
