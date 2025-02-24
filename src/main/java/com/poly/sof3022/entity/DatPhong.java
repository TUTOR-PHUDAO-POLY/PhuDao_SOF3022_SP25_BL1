package com.poly.sof3022.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "dat_phong")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DatPhong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_gio_dat")
    private Date ngayGioDat;

    @Column(name = "so_luong_khach")
    private Integer soLuongKhach;

    @Column(name = "so_luong_phong_dat")
    private Integer soLuongPhongDat;

    @Column(name = "ngay_tao")
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua")
    private Date ngayChinhSua;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

}
