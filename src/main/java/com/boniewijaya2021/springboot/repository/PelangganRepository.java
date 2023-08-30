package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Pelanggan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PelangganRepository extends JpaRepository<Pelanggan, String> {
}
