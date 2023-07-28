package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Transaksi;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.TransaksiPojo;
import com.boniewijaya2021.springboot.repository.BarangRepository;
import com.boniewijaya2021.springboot.repository.TransaksiRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public ResponseEntity<MessageModel> addTransaksi(List<TransaksiPojo> paramInsertTransaksi) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            // List<Pembeli> dataContoh = new ArrayList<>();
            //  dataContoh.add(paramInsert5s);
            List<TransaksiPojo> dataAwal = paramInsertTransaksi;

            List<String> dataReturn = new ArrayList<>();
//            String dataReturn  = "tersimpan";
//            List<Pembeli> simpanAll = new ArrayList<>();
            for(TransaksiPojo map1: dataAwal){

                Transaksi object1 = new Transaksi();
//                DataPembeli object1 = new DataPembeli();
                object1.setTanggal(map1.getTanggal());
                object1.setKeterangan(map1.getKeterangan());
                object1.setIdBarang(map1.getBarang().getIdBarang());
                object1.setIdPembeli(map1.getPembeli().getIdPembeli());
                UUID returningId = transaksiRepository.save(object1).returningId();
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

    public ResponseEntity getAllTransaksi() {
        MessageModel msg = new MessageModel();
        try{
            List<Transaksi> tdFaq = transaksiRepository.findAll();

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

    public ResponseEntity deleteTransaksi(UUID idTransaksi){
        MessageModel msg = new MessageModel();
        try{
            transaksiRepository.deleteById(idTransaksi);
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
