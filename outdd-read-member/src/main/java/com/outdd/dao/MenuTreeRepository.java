package com.outdd.dao;

import com.outdd.api.member.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nicky on 2017/6/17.
 */
public interface MenuTreeRepository extends JpaRepository<Menu,Integer>{

}
