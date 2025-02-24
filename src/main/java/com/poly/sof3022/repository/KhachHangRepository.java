package com.poly.sof3022.repository;

import com.poly.sof3022.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang,Integer> {

    KhachHang findByMa1(String ma);
}
