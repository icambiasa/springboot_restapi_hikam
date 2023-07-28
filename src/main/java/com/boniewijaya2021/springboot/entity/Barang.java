package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "barang", schema = "sample")
public class Barang implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_barang", nullable = false)
    private UUID idBarang;

    @Column(name = "nama_barang", nullable = false, length = 20)
    private String namaBarang;

    @Column(name = "harga")
    private Integer harga;

    @Column(name = "stok")
    private Integer stok;

    @Column(name = "id_supplier",  nullable = false)
    private UUID idSupplier;

    public UUID returningId(){

        return idBarang;
    }

//    @ManyToOne
//    @JoinColumn(name = "id_supplier",nullable = false, referencedColumnName = "id_supplier")
//    private Supplier supplier;

}
