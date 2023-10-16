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
@Table(name = "t_user_review")
public class TUserReview {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private TUser customer;

    @ManyToOne
    @JoinColumn(name = "bill_detail_id")
    private TBillDetail billDetail;

    @Column(name = "rating_value")
    private Integer ratingValue;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private Integer status;

}
