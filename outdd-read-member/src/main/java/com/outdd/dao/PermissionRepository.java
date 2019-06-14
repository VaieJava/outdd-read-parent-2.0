package com.outdd.dao;


import com.outdd.api.member.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nicky on 2017/11/11.
 */
public interface PermissionRepository extends JpaRepository<Permission,Integer> {

}
