package com.boniewijaya2021.springboot.pojo;

import com.boniewijaya2021.springboot.entity.Barang;
import com.boniewijaya2021.springboot.entity.Pembeli;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter

public class TransaksiPojo {
    private Date tanggal;
    private String keterangan;
    private Barang barang;
    private Pembeli pembeli;

}
