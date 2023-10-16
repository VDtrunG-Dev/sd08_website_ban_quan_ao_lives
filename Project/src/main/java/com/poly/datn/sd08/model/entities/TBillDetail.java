package com.poly.datn.sd08.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "t_bill_detail")
public class TBillDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private TBill bill;

    @ManyToOne
    @JoinColumn(name = "product_variation_id")
    private TProductVariation productVariation;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "subtotal_price")
    private BigDecimal subtotalPrice;

    @Column(name = "status")
    private Integer status;
}
