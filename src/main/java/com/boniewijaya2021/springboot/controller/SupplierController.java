package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.Supplier;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.SupplierPojo;
import com.boniewijaya2021.springboot.service.SupplierService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping("/post/supplier")
    private ResponseEntity<MessageModel> addSupplier(@RequestBody List<SupplierPojo> paramInsertSupplier) {
        ResponseEntity responseEntity = supplierService.addSupplier(paramInsertSupplier);
        return responseEntity;
    }

    @GetMapping("/get/dataSupplier")
    public ResponseEntity getDataSupplier(){
        ResponseEntity responseEntity = supplierService.getAllsupplier();
        return responseEntity;
    }

    @DeleteMapping("/delete/supplier")
    public ResponseEntity<MessageModel> deleteSupplier(@RequestParam UUID idSupplier) {
        ResponseEntity responseEntity = supplierService.deleteSupplier(idSupplier);
        return responseEntity;
    }
}