package com.outdd.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @description 菜单信息实体
 * @author Nicky
 * @date 2017年3月17日
 */
@Table(name="sys_menu")
@Entity
@Data
@Proxy(lazy = false)
public class Menu implements Serializable {

	/** 菜单Id**/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;
	
	/** 上级Id**/
	@Column(length=100)
	private Integer parentId;
	
	/** 菜单名称**/
	@Column(length=100)
	private String menuName;
	
	/** 菜单图标**/
	@Column(length=30)
	private String menuIcon;
	
	/** 菜单URL**/
	@Column(length=100)
	private String menuUrl;
	
	/** 菜单类型**/
	@Column(length=100)
	private String menuType;
	
	/** 菜单排序**/
	@Column(length=10)
	private String menuOrder;

	/**菜单状态**/
	@Column(length=10)
	private String menuStatus;

	@Transient
	private List<Menu> subMenu;

	@Transient
	private String target;

	@Transient
	private boolean hasSubMenu = false;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "parentId", referencedColumnName = "menuId")    //根据父级菜单ID，实现自关联（内部其实也就是一对多）
	private List<Menu> menus;


}
