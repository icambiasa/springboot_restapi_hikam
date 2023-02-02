package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class SampleGet {

    @Autowired
    private SalesService salesService;

    @GetMapping("/dataPenjualan")
    public ResponseEntity getDataPenjualan(@RequestParam Integer idSales ){
        ResponseEntity responseEntity = salesService.getDataPenjualan(idSales);
        return responseEntity;

    }
    @GetMapping("/dataPenjualanClass")
    public ResponseEntity getDataPenjualanDinamic( String namaSales, String namaBarang){
        ResponseEntity responseEntity = salesService.getPenjualanClassrepo(namaSales, namaBarang);
        return responseEntity;
    }
}
