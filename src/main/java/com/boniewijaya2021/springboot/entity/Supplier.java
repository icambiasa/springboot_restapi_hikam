package com.boniewijaya2021.springboot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplier", schema = "sample")
public class Supplier {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_supplier", nullable = false)
    private UUID idSupplier;

    @Column(name = "nama_supplier", nullable = false, length = 30)
    private String namaSupplier;

    @Column(name = "no_telp", length = 13)
    private String noTelp;

    @Column(name = "alamat", length = 100)
    private String alamat;

    public UUID returningId(){

        return idSupplier;
    }
}
