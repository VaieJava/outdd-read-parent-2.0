package com.outdd.dao;


import com.outdd.api.entity.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Nicky on 2017/12/3.
 */
public interface PermissionPageRepository extends PagingAndSortingRepository<Permission,Integer> {

}
