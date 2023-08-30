package com.boniewijaya2021.springboot.pojo;

import com.boniewijaya2021.springboot.entity.Supplier;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class BarangPojo {
    private String namaBarang;
    private Integer harga;
    private Integer stok;
    private Supplier supplier;
}
