package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaksi", schema = "sample")
public class Transaksi implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_transaksi", nullable = false)
    private UUID idTransaksi;


    @Column(name = "id_barang")
    private UUID idBarang;

    @Column(name = "id_pembeli")
    private UUID idPembeli;

    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @Column(name = "keterangan",nullable = false, length = 100)
    private String keterangan;

    public UUID returningId(){

        return idTransaksi;
    }

}
