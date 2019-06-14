package com.outdd.dao;

import java.util.List;

import com.outdd.api.member.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu,Integer> {

	/**
	 * 获取所有的上级菜单，并按菜单序号排序
	 * @return
	 */
	@Query(value = "select m from Menu m where m.parentId=0 order by m.menuOrder asc")
	public List<Menu> findAllParentMenu();

	/**
	 * 获取所有的上级菜单，并按菜单序号排序
	 * @return
	 */
	@Query(value = "SELECT m.* FROM sys_menu m LEFT JOIN sys_permission p on p.menuId = m.menuId LEFT JOIN sys_role_permission rp on rp.permissionId = p.id LEFT JOIN sys_role r on r.roleId = r.roleId = rp.roleId LEFT JOIN sys_user_role ur on ur.roleId = r.roleId LEFT JOIN sys_user u on u.id = ur.userId WHERE u.id = :id and m.parentId=0 and m.menuStatus=1 GROUP BY m.menuId order by m.menuOrder asc", nativeQuery = true)
	public List<Menu> findMenusByUserId(@Param("id") int id);
	
	/**
	 * 根据上级菜单Id获取二级菜单，并按菜单序号排序id
	 * @param
	 * @return
	 */
	@Query(value = "select m from Menu m where m.parentId=:id order by m.menuOrder asc")
	public List<Menu> findSubMenuByParentId(@Param("id") int id);

	/**
	 * 根据上级菜单Id获取二级菜单，并按菜单序号排序id
	 * @param
	 * @return
	 */
	@Query(value = "select m from Menu m where m.menuUrl like %:path% order by m.menuOrder asc")
	public List<Menu> findSubMenuByPath(@Param("path") String path);

	/**
	 * 通过菜单Id获取菜单信息
	 * @return
	 */
	@Query(value = "select m from Menu m where m.menuId=:id")
	public Menu findMenuByMenuId(@Param("id") int id);




}
