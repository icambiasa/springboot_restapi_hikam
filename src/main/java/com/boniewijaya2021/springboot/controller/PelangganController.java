package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.Supplier;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.DataPembeli;
import com.boniewijaya2021.springboot.pojo.NamaMobilPojo;
import com.boniewijaya2021.springboot.pojo.PelangganPojo;
import com.boniewijaya2021.springboot.repository.BarangRepository;
import com.boniewijaya2021.springboot.repository.NamaMobilRepository;
import com.boniewijaya2021.springboot.repository.SupplierRepository;
import com.boniewijaya2021.springboot.service.*;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pelanggan")
public class PelangganController {
    @Autowired
    PelangganService pelangganService;

    @PostMapping("/post/pelanggan")
    private ResponseEntity<MessageModel> addPelanggan(@RequestBody List<PelangganPojo> paramInsertPelanggan) {
        ResponseEntity responseEntity = pelangganService.addPelanggan(paramInsertPelanggan);
        return responseEntity;
    }

    @GetMapping("/get/pelanggan")
    public ResponseEntity getPelanggan(){
        ResponseEntity responseEntity = pelangganService.getAllPelangganMobil();
        return responseEntity;
    }

}
