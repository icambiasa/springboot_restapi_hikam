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
@Table(name = "pembayaran", schema = "sample")
public class Pembayaran implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pemabayaran", nullable = false)
    private UUID idPembayaran;

    @Column(name = "tgl_bayar", nullable = false)
    private Date tglBayar;

    @Column(name = "total_bayar")
    private int totalBayar;

    @Column(name = "id_transaksi", nullable = false)
    private Transaksi transaksi;
}
