package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblMasterRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TblMasterRoleRepository extends JpaRepository<TblMasterRole, UUID> {
}
