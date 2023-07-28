package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PembeliRepository extends JpaRepository<Pembeli, UUID> {
}



