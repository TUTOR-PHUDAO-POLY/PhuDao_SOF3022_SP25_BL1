package com.poly.sof3022.controller;

import com.poly.sof3022.entity.DatPhong;
import com.poly.sof3022.entity.KhachHang;
import com.poly.sof3022.repository.DatPhongRepository;
import com.poly.sof3022.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Controller
public class DatPhongController {

    @Autowired
    private KhachHangRepository khacHangRepository;

    @Autowired
    private DatPhongRepository datPhongRepository;

    @GetMapping("/dat-phong/hien-thi")
    public String hienThiDuLieu(Model model) {
        model.addAttribute("listKhachHang", khacHangRepository.findAll());
        model.addAttribute("listDatPhong", datPhongRepository.findAll());
        model.addAttribute("datPhong",new DatPhong());
        return "view-dat-phong";
    }

    @GetMapping("/dat-phong/remove/{id2}")
    public String removeDuLieu(@PathVariable("id2") Integer id) {
        datPhongRepository.deleteById(id);
        return "redirect:/dat-phong/hien-thi";
    }

    @PostMapping("/dat-phong/add")
    public String addDuLieu(@RequestParam("maDatPhong") String maDatPhong,
                            @RequestParam("tenDatPhong") String tenDatPhong,
                            @RequestParam("maKhachHang") String maKhachHang){
        KhachHang kh = khacHangRepository.findByMa1(maKhachHang);
        DatPhong dh = DatPhong.builder()
                .ma(maDatPhong)
                .khachHang(kh)
                .ten(tenDatPhong)
                .ngayTao(Calendar.getInstance().getTime()) // lay ra ngay h hien tai
                .trangThai(1)
                .build();
        datPhongRepository.save(dh);
        return "redirect:/dat-phong/hien-thi";
    }

    @GetMapping("/dat-phong/detail/{id1}")
    public String detailDuLieu(@PathVariable("id1") Integer id,Model model) {
        DatPhong  dh = datPhongRepository.findById(id).get();
        model.addAttribute("datPhong",dh);
        model.addAttribute("listKhachHang", khacHangRepository.findAll());
        model.addAttribute("listDatPhong", datPhongRepository.findAll());
        return "view-dat-phong";
    }
}
