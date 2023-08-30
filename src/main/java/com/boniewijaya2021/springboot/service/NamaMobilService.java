package com.boniewijaya2021.springboot.service;


import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.NamaMobil;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.NamaMobilPojo;
import com.boniewijaya2021.springboot.repository.NamaMobilRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
@Service

public class NamaMobilService {
    @Autowired
    NamaMobilRepository namaMobilRepository;

    public ResponseEntity<MessageModel> addNamaMobil(List<NamaMobilPojo> paramInsertNamaMobil) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            // List<Pembeli> dataContoh = new ArrayList<>();
            //  dataContoh.add(paramInsert5s);
            List<NamaMobilPojo> dataAwal = paramInsertNamaMobil;

            List<String> dataReturn = new ArrayList<>();
//            String dataReturn  = "tersimpan";
//            List<Pembeli> simpanAll = new ArrayList<>();
            for(NamaMobilPojo map1: dataAwal){

                NamaMobil object1 = new NamaMobil();
//                DataPembeli object1 = new DataPembeli();
                object1.setNamaMobil(map1.getNamaMobil());
                object1.setModels(map1.getModels());
                String returningId = namaMobilRepository.save(object1).returningId();
                dataReturn.add(returningId.toString());
//                simpanAll.add(object1);

            }
//            pembeliRepository.saveAll(simpanAll);
//            Pembeli simpan = new Pembeli();
//            List<Pembeli> sumber = new ArrayList<>();
//            sumber.add((Pembeli) pembeli);
//            for(ParamInsert5 map: simpan) {
//                TblPembeli postData = new Pembeli();
//                postData.setNamaPembeli(map.);
//                postData.setJenisKelamin(map.getJenisKelamin());
//                postData.setAlamat(map.getAlamat());
//                postData.setNoTelp(map.getNoTelp());
//                pembeliRepository.save(postData);
//            }
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", dataReturn);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
    public ResponseEntity getAllNamaMobil() {
        MessageModel msg = new MessageModel();
        try{
            List<NamaMobil> tdFaq = namaMobilRepository.findAll();

            if (!tdFaq.isEmpty()) {
                return ResponseEntity.ok(tdFaq);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data found");
            }
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}


