package com.poly.sof3022.controller;

import com.poly.sof3022.repository.DatPhongRepository;
import com.poly.sof3022.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatPhongController {

    @Autowired
    private KhachHangRepository khacHangRepository;

    @Autowired
    private DatPhongRepository datPhongRepository;

    @GetMapping("/dat-phong/hien-thi")
    public String hienThiDuLieu(Model model){
        model.addAttribute("listKhachHang", khacHangRepository.findAll());
        model.addAttribute("listDatPhong", datPhongRepository.findAll());
        return "view-dat-phong";
    }
}
