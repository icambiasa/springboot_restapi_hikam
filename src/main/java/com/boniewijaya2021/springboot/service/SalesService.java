package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
import com.boniewijaya2021.springboot.repository.SalesRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

//    public SalesService(SalesRepository salesRepository) {
//        this.salesRepository = salesRepository;
//    }

    public ResponseEntity getDataPenjualan(Integer idSales){
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            PenjualanPojo data = salesRepository.getPenjualanByid(idSales);
            if(data ==null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("data", data);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }


    }

}
