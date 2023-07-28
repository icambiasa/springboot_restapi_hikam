package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.DataPembeli;
import com.boniewijaya2021.springboot.repository.BarangRepository;
import com.boniewijaya2021.springboot.repository.PembeliRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
@Service

public class BarangService {
    @Autowired
    BarangRepository barangRepository;

    public ResponseEntity<MessageModel> addBarang(List<BarangPojo> paramInsertBarang) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            // List<Pembeli> dataContoh = new ArrayList<>();
            //  dataContoh.add(paramInsert5s);
            List<BarangPojo> dataAwal = paramInsertBarang;

            List<String> dataReturn = new ArrayList<>();
//            String dataReturn  = "tersimpan";
//            List<Pembeli> simpanAll = new ArrayList<>();
            for(BarangPojo map1: dataAwal){

                Barang object1 = new Barang();
//                DataPembeli object1 = new DataPembeli();
                object1.setNamaBarang(map1.getNamaBarang());
                object1.setHarga(map1.getHarga());
                object1.setStok(map1.getStok());
                object1.setIdSupplier(map1.getSupplier().getIdSupplier());
                UUID returningId = barangRepository.save(object1).returningId();
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

    public ResponseEntity getAllBarang() {
        MessageModel msg = new MessageModel();
        try{
            List<Barang> tdFaq = barangRepository.findAll();

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

    public ResponseEntity deleteBarang(UUID idPembeli){
        MessageModel msg = new MessageModel();
        try{
            barangRepository.deleteById(idPembeli);
            msg.setStatus(true);
            msg.setMessage("Data Deleted");
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}

