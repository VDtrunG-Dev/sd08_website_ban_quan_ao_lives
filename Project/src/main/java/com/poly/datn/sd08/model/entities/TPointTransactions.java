package com.poly.datn.sd08.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "t_point_transactions")
public class TPointTransactions {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private TUser customer;

    @Column(name = "transaction_type")
    private Integer transactionType;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "transaction_amount")
    private BigDecimal transactionAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;
}
