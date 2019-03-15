package com.outdd.api.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 角色信息实体类
 * @author Nicky
 * @date 2017年3月16日
 */
@Table(name="sys_role")
@Entity
@Data
public class Role implements GrantedAuthority {

	/** 角色Id**/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;

	/** 角色描述**/
	@Column(length=100)
	private String roleDesc;

	/** 角色名称**/
	@Column(length=100)
	private String roleName;

	/** 角色标志**/
	@Column(length=100)
	private String role;

	//修改cascade策略为级联关系
	@OneToMany(targetEntity=Permission.class,cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinTable(name="sys_role_permission", joinColumns=@JoinColumn(name="roleId",referencedColumnName="roleId"), inverseJoinColumns=@JoinColumn(name="permissionId",referencedColumnName="id",unique=true))
	private Set<Permission> permissions = new HashSet<Permission>();



	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Role) {
			Role role = (Role) obj;
			return this.roleId==(role.getRoleId())
					&& this.roleName.equals(role.getRoleName())
					&& this.roleDesc.equals(role.getRoleDesc())
					&& this.role.equals(role.getRole());
		}
		return super.equals(obj);
	}

	@Override
	public String getAuthority() {
		return roleName;
	}
}
