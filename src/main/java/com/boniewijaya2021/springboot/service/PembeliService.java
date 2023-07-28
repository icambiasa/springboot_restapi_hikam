package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Pembeli;
import com.boniewijaya2021.springboot.pojo.DataPembeli;
import com.boniewijaya2021.springboot.repository.PembeliRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository pembeliRepository;

    public ResponseEntity<MessageModel> addPembeli(List<DataPembeli> paramInsert5) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            // List<Pembeli> dataContoh = new ArrayList<>();
            //  dataContoh.add(paramInsert5s);
            List<DataPembeli> dataAwal = paramInsert5;

            List<String> dataReturn = new ArrayList<>();
//            String dataReturn  = "tersimpan";
//            List<Pembeli> simpanAll = new ArrayList<>();
            for(DataPembeli map1: dataAwal){

                Pembeli object1 = new Pembeli();
//                DataPembeli object1 = new DataPembeli();
                object1.setNamaPembeli(map1.getNamaPembeli());
                object1.setAlamat(map1.getAlamat());
                object1.setJenisKelamin(map1.getJenisKelamin());
                object1.setNoTelp(map1.getNoTelp());
                UUID returningId = pembeliRepository.save(object1).returningId();
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

    public ResponseEntity getAllPembeli() {
        MessageModel msg = new MessageModel();
        try{
            List<Pembeli> tdFaq = pembeliRepository.findAll();

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

    public ResponseEntity deletePembeli(UUID idPembeli){
        MessageModel msg = new MessageModel();
        try{
            pembeliRepository.deleteById(idPembeli);
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