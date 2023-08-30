package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales", schema = "sample")
public class NamaMobil implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")

    @Column(name = "nama_mobil", nullable = false, length = 20)
    private String namaMobil;

    @Column(name = "models")
    private String models;


    public String returningId() {

        return namaMobil;
    }
}