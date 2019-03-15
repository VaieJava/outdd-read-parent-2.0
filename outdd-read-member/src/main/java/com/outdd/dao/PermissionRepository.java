package com.outdd.dao;


import com.outdd.api.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nicky on 2017/11/11.
 */
public interface PermissionRepository extends JpaRepository<Permission,Integer> {

}
