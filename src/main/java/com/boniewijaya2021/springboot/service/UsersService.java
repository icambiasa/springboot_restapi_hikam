package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblUsers;
import com.boniewijaya2021.springboot.pojo.UsersPojo;
import com.boniewijaya2021.springboot.repository.UsersRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public ResponseEntity<MessageModel> addDataUsers(TblUsers tblUsers) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            usersRepository.save(tblUsers);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblUsers);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity getDataUser(){
//        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            List<UsersPojo> data = usersRepository.getUser();
            if(data  == null) {
                msg.setStatus(true);
                msg.setMessage("data tidak ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
//                result.put("data", data);
                msg.setData(data);
                return ResponseEntity.ok().body(msg);
            }

        }catch (Exception e){
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);

        }


    }
}
