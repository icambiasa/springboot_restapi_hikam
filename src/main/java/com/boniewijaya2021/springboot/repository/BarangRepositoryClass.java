//package com.boniewijaya2021.springboot.repository;
//
//import com.boniewijaya2021.springboot.pojo.BarangPojo;
//import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//@Repository
//public class BarangRepositoryClass {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<BarangPojo> getDataDinamic(String namaBarang
//    )
//    {
//        StringBuilder qb = new StringBuilder();
//
//        if(namaBarang !=null ){
//            qb.append(" and nama_barang = :namaBarang \n");
//        }
//
//
//        String sisipan = qb.toString();
//
//        //untuk sisipan yang ditengah
//
//        String QueryText="SELECT " +
//                "cast (id_penjualan as varchar) id_penjualan, " +
//                "harga, " +
//                "nama_barang," +
//                " sales_name\n" +
//                "FROM sample.tbl_penjualan  WHERE 1=1 \n" +sisipan;
//
//        Query query = entityManager.createNativeQuery(QueryText);
//        if(namaBarang !=null){
//            query.setParameter("namaBarang",namaBarang);
//        }
//
//
//
//
//        List hasil= query.getResultList();
//        List<PenjualanPojo> result = new ArrayList<>();
//
//        Iterator itr = hasil.iterator();
//        while(itr.hasNext()){
//            PenjualanPojo browse = new PenjualanPojo();
//            Object[] obj = (Object[]) itr.next();
//            String idPenjualan= String.valueOf(obj[0]);
//            Double harga = Double.valueOf((Double) obj[1]);
//            String namaBarangs = String.valueOf(obj[2]);
//            String salesName= String.valueOf(obj[3]);
//
//            browse.setIdPenjualan(idPenjualan);
//            browse.setHarga(harga);
//            browse.setNamaBarang(namaBarangs);
//            browse.setSalesName(salesName);
//            result.add(browse);
//        }
//        return result;
//    }
//
//
//}
