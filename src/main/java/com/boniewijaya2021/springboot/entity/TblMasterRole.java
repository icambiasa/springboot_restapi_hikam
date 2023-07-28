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
@Table(name = "tbl_master_role", schema = "sample")
public class TblMasterRole implements Serializable{
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    //@Column(columnDefinition = "serial")
    @Column(name = "master_role_id", nullable = false)
    private UUID masterRoleId;

    @Column(name = "role_id", nullable = false)
    private UUID roleId;

    @Column(name = "role_name", nullable = false)
    private String roleName;
}
