package com.poly.datn.sd08.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "t_bill")
public class TBill {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private TUser user;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private TAddress address;

    @Column(name = "shipping_method_id")
    private Long shippingMethodId;

    @Column(name = "bill_status_id")
    private Long billStatusId;

    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "bill_code")
    private String billCode;

    @Column(name = "recipient_phone")
    private String recipientPhone;

    @Column(name = "cash")
    private BigDecimal cash;

    @Column(name = "money_transfer")
    private BigDecimal moneyTransfer;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "total_amount_after_discount")
    private BigDecimal totalAmountAfterDiscount;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

}
