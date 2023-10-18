package com.poly.datn.sd08.repositories;

import com.poly.datn.sd08.model.entities.TRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository  extends JpaRepository<TRank, Long> {
}
