package com.boniewijaya2021.springboot.service;

import com.boniewijaya2021.springboot.entity.TblMasterRole;
import com.boniewijaya2021.springboot.entity.TblRoleMap;
import com.boniewijaya2021.springboot.repository.TblMasterRoleRepository;
import com.boniewijaya2021.springboot.repository.TblRoleMapRepository;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MasterRoleService {
    @Autowired
    TblMasterRoleRepository tblMasterRoleRepository;

    public ResponseEntity<MessageModel> addMasterRole(TblMasterRole tblMasterRole) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            tblMasterRoleRepository.save(tblMasterRole);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("data", tblMasterRole);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
