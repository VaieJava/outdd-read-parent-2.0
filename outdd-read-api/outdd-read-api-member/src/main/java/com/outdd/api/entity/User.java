package com.outdd.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * 用户信息的实体类
 * @author Nicky
 */
@Entity
@Table(name="sys_user")
@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements UserDetails {
	public User (){
		super();
	}

	/** 用户Id**/
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;

	/** 用户名**/
	@Column(unique=true,length=100,nullable=false)
	private String username;

	/** 用户密码**/
	@Column(length=100,nullable=false)
	private String password;

	/** 手机号**/
	@Column(length = 11)
	private String phone;

	/** 性别**/
	@Column(length=6)
	private String sex;

	/** 邮件**/
	@Column(length=100)
	private String email;

	/** 备注**/
	@Column(length=100)
	private String mark;

	/** 用户级别**/
	@Column(length=10)
	private String rank;

	/** 最后一次时间**/
	@Temporal(TemporalType.DATE)
	private Date lastLogin;

	/** 登录ip**/
	@Column(length=100)
	private String loginIp;

	/** 图片路径**/
	@Column(length=100)
	private String imageUrl;

	/** 注册时间**/
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date regTime;

	/** 账号是否被锁定**/
	private Boolean locked = Boolean.FALSE;

	/** 权限**/
	private String rights;


	//修改cascade策略为级联关系
	@ManyToMany(targetEntity = Role.class, cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "sys_user_role", joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId") )
	private Set<Role> roles;
	@Transient
	private Set<Role> authorities = new HashSet<>();
//	@Transient
//	private boolean enabled=true;
//	@Transient
//	private boolean accountNonExpired=true;
//	@Transient
//	private boolean accountNonLocked=true;
//	@Transient
//	private boolean credentialsNonExpired=true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		// 包裹用户单独赋予的角色
		authorities.addAll(roles);

		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


}
