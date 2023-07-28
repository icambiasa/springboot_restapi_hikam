package com.boniewijaya2021.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersPojo {
    private String userName;
    private String email;
    private String roleName;
}
