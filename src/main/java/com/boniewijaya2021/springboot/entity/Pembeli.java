package com.boniewijaya2021.springboot.entity;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pembeli", schema = "sample")
public class Pembeli implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pembeli",nullable = false)
    private UUID idPembeli;


    @Column(name = "nama_pembeli", nullable = false, length = 30)
    private String namaPembeli;


    @Column(name = "jk", nullable = false, length = 1)
    private String jenisKelamin;


    @Column(name = "no_telp", nullable = false, length = 14)
    private String noTelp;


    @Column(name = "alamat", nullable = false, length = 50)
    private String alamat;

public UUID returningId(){
    return idPembeli;
}



//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "id_pembeli")
//    private List<Pembeli> idPembeli = new ArrayList<>();
//
//    // Constructors, getters, and setters
//
//    public void addPembeli(Pembeli pembeli) {
//        idPembeli.add(pembeli);
//    }
//
//    public void removePembeli(Pembeli pembeli) {
//        idPembeli.remove(pembeli);
}



