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
@Table(name = "t_product_option")
public class TProductOption {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private TProduct product;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private TOption option;

    @Column(name = "status")
    private Integer status;

}
