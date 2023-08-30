package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.Supplier;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.DataPembeli;
import com.boniewijaya2021.springboot.pojo.NamaMobilPojo;
import com.boniewijaya2021.springboot.repository.BarangRepository;
import com.boniewijaya2021.springboot.repository.NamaMobilRepository;
import com.boniewijaya2021.springboot.repository.SupplierRepository;
import com.boniewijaya2021.springboot.service.BarangService;
import com.boniewijaya2021.springboot.service.NamaMobilService;
import com.boniewijaya2021.springboot.service.PembeliService;
import com.boniewijaya2021.springboot.service.SupplierService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/namaMobil")
public class NamaMobilController {
    @Autowired
    NamaMobilService namaMobilService;

    @PostMapping("/post/namaMobil")
    private ResponseEntity<MessageModel> addNamaMobil(@RequestBody List<NamaMobilPojo> paramInsertNamaMobil) {
        ResponseEntity responseEntity = namaMobilService.addNamaMobil(paramInsertNamaMobil);
        return responseEntity;
    }

    @GetMapping("/get/namaMobil")
    public ResponseEntity getNamaMobil(){
        ResponseEntity responseEntity = namaMobilService.getAllNamaMobil();
        return responseEntity;
    }

}
