package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblRoleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TblRoleMapRepository extends JpaRepository<TblRoleMap, UUID> {
}
