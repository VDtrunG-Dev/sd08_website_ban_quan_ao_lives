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
@Table(name = "t_rank")
public class TRank {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rank_name")
    private String rankName;

    @Column(name = "minimum_points")
    private Integer minimumPoints;

    @Column(name = "status")
    private Integer status;

}
