package com.outdd.dao;

import com.outdd.api.member.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nicky on 2017/12/2.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
