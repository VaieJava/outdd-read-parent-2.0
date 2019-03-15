package com.outdd.dao;


import com.outdd.api.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nicky on 2017/12/2.
 */
public interface UserRoleRepository extends JpaRepository<RolePermission,String> {
}
