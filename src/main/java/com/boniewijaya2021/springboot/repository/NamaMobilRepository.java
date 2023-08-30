package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.NamaMobil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NamaMobilRepository extends JpaRepository<NamaMobil, String> {
}
