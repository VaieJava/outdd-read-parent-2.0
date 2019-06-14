package com.outdd.dao;

import com.outdd.api.member.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Nicky on 2017/7/30.
 */
public interface RolePageRepository extends PagingAndSortingRepository<Role, Integer> {

//    @Query("from Role r where r.roleId=:id")
//    Role findByRoleId(@Param("id") int id);



}
