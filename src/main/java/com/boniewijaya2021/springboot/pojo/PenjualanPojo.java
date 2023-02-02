package com.boniewijaya2021.springboot.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PenjualanPojo {
    private Integer idPenjualan;
    private String namaBarang;
    private Double harga;
    private String salesName;
}
