//package com.boniewijaya2021.springboot.repository;
//
//import com.boniewijaya2021.springboot.pojo.PenjualanPojo;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class SalesRepository extends JpaRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public List<PenjualanPojo> getPenjualan(Integer idSales)
//    {
//
//        StringBuilder qb = new StringBuilder();
//        if(idHeader !=null ){
//            qb.append(" AND ta.id_header =:idHeader \n");
//        }
//
//        String sisipan = qb.toString();
//
//        String QueryText =" select distinct \n" +
//                "    ta.id_ap,\n" +
//                "    ta.id_header,\n" +
//                "    tdi.kode_ijin,\n" +
//                "    tdi.keterangan,\n" +
//                "    tdi.nomor_ijin,\n" +
//                "    tdi.tanggal_ijin, \n" +
//                "    tdi.flag_pakai, \n" +
//                "    tb.jumlah_satuan, \n" +
//                "    tb.jumlah_kemasan, \n" +
//                "    tb.uraian, \n" +
//                "    tdi.nomor_identitas, \n" +
//                "    tdi.tanggal_awal_berlaku, \n" +
//                "    tdi.tanggal_akhir_berlaku \n" +
//                "FROM tt_barang tb \n" +
//                "JOIN td_ap ta ON ta.id_header = tb.id_header \n" +
//                "LEFT JOIN tr_dokumen_ijin tdi ON tdi.kode_hs = tb.pos_tarif \n" +
//                "JOIN tt_entitas te ON te.nomor_identitas = tdi.nomor_identitas \n" +
//                "WHERE 1=1 \n"  +
//                sisipan;
//
//        Query query = entityManager.createNativeQuery(QueryText);
//        if (idHeader != null) {
//            query.setParameter("idHeader",idHeader);
//        }
//
//        List hasil= query.getResultList();
//        List<dataDokumenPojo> result = new ArrayList<>();
//
//
//        Iterator itr = hasil.iterator();
//        while(itr.hasNext()){
//            dataDokumenPojo browse = new dataDokumenPojo();
//            Object[] obj = (Object[]) itr.next();
//            String id_ap= String.valueOf(obj[0]);
//            String id_header=String.valueOf(obj[1]);
//            String kode_ijin=String.valueOf(obj[2]);
//            String keterangan=String.valueOf(obj[3]);
//            String nomor_ijin=String.valueOf(obj[4]);
//            String tanggal_ijin=String.valueOf(obj[5]);
//            String flag_pakai= String.valueOf(obj[6]);
//            String jumlah_satuan=String.valueOf(obj[7]);
//            String jumlah_kemasan=String.valueOf(obj[8]);
//            String uraian=String.valueOf(obj[9]);
//            String nomor_identitas=String.valueOf(obj[10]);
//            Date tanggal_awal_berlaku = Date.valueOf(String.valueOf(obj[11]));
//            Date tanggal_akhir_berlaku = Date.valueOf(String.valueOf(obj[12]));
//
//            browse.setIdAp(id_ap);
//            browse.setIdHeader(id_header);
//            browse.setKodeIjin(kode_ijin);
//            browse.setKeterangan(keterangan);
//            browse.setNomorIjin(nomor_ijin);
//            browse.setTanggalIjin(tanggal_ijin);
//            browse.setFlagPakai(flag_pakai);
//            browse.setJumlahSatuan(jumlah_satuan);
//            browse.setJumlahKemasan(jumlah_kemasan);
//            browse.setUraian(uraian);
//            browse.setNomorIdentitas(nomor_identitas);
//            browse.setTanggalAwalBerlaku(tanggal_awal_berlaku);
//            browse.setTanggalAkhirBerlaku(tanggal_akhir_berlaku);
//            result.add(browse);
//        }
//        return result;
//    }
//}
