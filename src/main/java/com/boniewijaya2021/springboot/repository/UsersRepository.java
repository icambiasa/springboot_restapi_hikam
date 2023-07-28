package com.boniewijaya2021.springboot.repository;

import com.boniewijaya2021.springboot.entity.TblUsers;
import com.boniewijaya2021.springboot.pojo.UsersPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<TblUsers,UUID> {

    @Query(value = "SELECT u.user_name, u.email, mr.role_name " +
            "FROM sample.tbl_users u " +
            "JOIN sample.tbl_role_map rm ON u.user_id = rm.user_id " +
            "JOIN sample.tbl_master_role mr ON rm.role_id = mr.role_id " +
            "WHERE u.status = 'aktif' ", nativeQuery = true)
    List<UsersPojo> getUser();
}
