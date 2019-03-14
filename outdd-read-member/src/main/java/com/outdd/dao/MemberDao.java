package com.outdd.dao;

import com.outdd.api.entity.UserEntity;

/**
 * @author vaie
 * @Created 2019/1/26 17:37
 */
public interface MemberDao {
    int deleteByPrimaryKey(String userId);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String userId);

    UserEntity selectByPrimaryName(String userName);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}
