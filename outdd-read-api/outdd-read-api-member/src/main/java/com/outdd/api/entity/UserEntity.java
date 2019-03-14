package com.outdd.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author vaie
 * @Created 2019/1/26 17:35
 */
@Data
public class UserEntity{
    private String userId;

    private String loginName;

    private String password;

    private String vsername;

    private String mobile;

    private String email;

    private Date genTime;

    private Date loginTime;

    private Date lastLoginTime;

    private Integer loginCount;

    private String viaIcon;

    private static final long serialVersionUID = 1L;

}
