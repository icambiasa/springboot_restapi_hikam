package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblSales;
import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SalesRepository extends JpaRepository<TblSales, Integer> {
    @Query(value = "SELECT id_penjualan, harga, nama_barang, sales_name\n" +
            "FROM sample.tbl_penjualan where id_penjualan =:idSales", nativeQuery = true)
    PenjualanPojo getPenjualanByid(@Param("idSales") Integer idSales);



}
