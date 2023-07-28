package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.TransaksiPojo;
import com.boniewijaya2021.springboot.service.BarangService;
import com.boniewijaya2021.springboot.service.TransaksiService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
        @Autowired
        TransaksiService transaksiService;

        @PostMapping("/post/transaksi")
        private ResponseEntity<MessageModel> addTransaksi(@RequestBody List<TransaksiPojo> paramInserttransaksi) {
            ResponseEntity responseEntity = transaksiService.addTransaksi(paramInserttransaksi);
            return responseEntity;
        }

        @GetMapping("/get/dataTransaksi")
        public ResponseEntity getDataTransaksi(){
            ResponseEntity responseEntity = transaksiService.getAllTransaksi();
            return responseEntity;
        }

        @DeleteMapping("/delete/transaksi")
        public ResponseEntity<MessageModel> deletetransaksi(@RequestParam UUID idTransaksi) {
            ResponseEntity responseEntity = transaksiService.deleteTransaksi(idTransaksi);
            return responseEntity;
        }
}


