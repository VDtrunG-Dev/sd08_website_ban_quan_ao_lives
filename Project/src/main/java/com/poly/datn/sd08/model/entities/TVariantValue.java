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
@Table(name = "t_variant_value")
public class TVariantValue {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_option_id")
    private TProductOption productOption;

    @ManyToOne
    @JoinColumn(name = "option_value_id")
    private TOptionValue optionValue;

    @Column(name = "status")
    private Integer status;

}
