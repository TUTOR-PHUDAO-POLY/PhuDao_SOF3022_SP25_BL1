package com.poly.sof3022.repository;

import com.poly.sof3022.entity.DatPhong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatPhongRepository extends JpaRepository<DatPhong,Integer> {
}
