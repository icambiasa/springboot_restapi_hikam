package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.Supplier;
import com.boniewijaya2021.springboot.repository.SupplierRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public ResponseEntity<MessageModel> addSupplier(Supplier supplier) {
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            supplierRepository.save(supplier);
            msg.setStatus(true);
            msg.setMessage("Success");
//            result.put("data", supplier);
            msg.setData(supplier);
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
