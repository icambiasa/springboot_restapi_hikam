package com.boniewijaya2021.springboot.controller;


import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.pojo.DataPembeli;
import com.boniewijaya2021.springboot.service.PembeliService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    PembeliService pembeliService;

    @PostMapping("/post/pembeli")
    private ResponseEntity<MessageModel> addPembeli(@RequestBody List<DataPembeli> paramInsert5) {
        ResponseEntity responseEntity = pembeliService.addPembeli(paramInsert5);
        return responseEntity;
    }

    @GetMapping("/get/dataPembeli")
    public ResponseEntity getDataPembeli(){
        ResponseEntity responseEntity = pembeliService.getAllPembeli();
        return responseEntity;
    }

    @DeleteMapping("/delete/pembeli")
    public ResponseEntity<MessageModel> deletePembeli(@RequestParam UUID idPembeli) {
        ResponseEntity responseEntity = pembeliService.deletePembeli(idPembeli);
        return responseEntity;
    }
}
