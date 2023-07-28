package com.boniewijaya2021.springboot.controller;

import com.boniewijaya2021.springboot.entity.TblMasterRole;
import com.boniewijaya2021.springboot.entity.TblRoleMap;
import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.entity.TblUsers;
import com.boniewijaya2021.springboot.service.MasterRoleService;
import com.boniewijaya2021.springboot.service.RoleMapService;
import com.boniewijaya2021.springboot.service.UsersService;
import com.boniewijaya2021.springboot.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post-user")
public class UsersController {

    @Autowired
    UsersService userService;
    @Autowired
    RoleMapService roleMapService;
    @Autowired
    MasterRoleService masterMapService;
    @PostMapping("/post/user")
    private ResponseEntity<MessageModel> addUsers(@RequestBody TblUsers tblUsers) {
        ResponseEntity responseEntity = userService.addDataUsers(tblUsers);
        return responseEntity;
    }
    @PostMapping("/post/rolemap")
    private ResponseEntity<MessageModel> addRoleMap(@RequestBody TblRoleMap tblRoleMap) {
        ResponseEntity responseEntity = roleMapService.addRoleMap(tblRoleMap);
        return responseEntity;
    }
    @PostMapping("/post/master-role")
    private ResponseEntity<MessageModel> addUMasterRole(@RequestBody TblMasterRole tblMasterRole) {
        ResponseEntity responseEntity = masterMapService.addMasterRole(tblMasterRole);
        return responseEntity;
    }

    @GetMapping("/get/dataPenjualanClass")
    public ResponseEntity getDataPenjualanDinamic(){
        ResponseEntity responseEntity = userService.getDataUser();
        return responseEntity;
    }
}
