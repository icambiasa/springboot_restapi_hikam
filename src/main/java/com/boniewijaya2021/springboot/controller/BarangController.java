package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.DataPembeli;
import com.boniewijaya2021.springboot.service.BarangService;
import com.boniewijaya2021.springboot.service.PembeliService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService barangService;

    @PostMapping("/post/barang")
    private ResponseEntity<MessageModel> addBarang(@RequestBody List<BarangPojo> paramInsertbarang) {
        ResponseEntity responseEntity = barangService.addBarang(paramInsertbarang);
        return responseEntity;
    }

    @GetMapping("/get/dataBarang")
    public ResponseEntity getDataBarang(){
        ResponseEntity responseEntity = barangService.getAllBarang();
        return responseEntity;
    }

    @DeleteMapping("/delete/barang")
    public ResponseEntity<MessageModel> deleteBarang(@RequestParam UUID idBarang) {
        ResponseEntity responseEntity = barangService.deleteBarang(idBarang);
        return responseEntity;
    }
}
