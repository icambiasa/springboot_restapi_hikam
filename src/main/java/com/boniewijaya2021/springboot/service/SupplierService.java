package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Supplier;
import com.boniewijaya2021.springboot.pojo.BarangPojo;
import com.boniewijaya2021.springboot.pojo.SupplierPojo;
import com.boniewijaya2021.springboot.repository.SupplierRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public ResponseEntity<MessageModel> addSupplier(List<SupplierPojo> paramInsertSupplier) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            // List<Pembeli> dataContoh = new ArrayList<>();
            //  dataContoh.add(paramInsert5s);
            List<SupplierPojo> dataAwal = paramInsertSupplier;

            List<String> dataReturn = new ArrayList<>();
//            String dataReturn  = "tersimpan";
//            List<Pembeli> simpanAll = new ArrayList<>();
            for(SupplierPojo map1: dataAwal){

                Supplier object1 = new Supplier();
//                DataPembeli object1 = new DataPembeli();
                object1.setNamaSupplier(map1.getNamaSuplier());
                object1.setNoTelp(map1.getNoTelp());
                object1.setAlamat(map1.getAlamat());
                UUID returningId = supplierRepository.save(object1).returningId();
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

    public ResponseEntity getAllsupplier() {
        MessageModel msg = new MessageModel();
        try{
            List<Supplier> tdFaq = supplierRepository.findAll();

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
    public ResponseEntity deleteSupplier(UUID idSupplier){
        MessageModel msg = new MessageModel();
        try{
            supplierRepository.deleteById(idSupplier);
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
