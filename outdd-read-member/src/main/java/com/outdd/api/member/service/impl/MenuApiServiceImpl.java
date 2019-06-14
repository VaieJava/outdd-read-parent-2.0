package com.outdd.api.member.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.outdd.api.member.entity.Menu;
import com.outdd.api.member.entity.MenuHelp;
import com.outdd.api.member.service.MenuApiService;
import com.outdd.base.BaseApiService;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import com.outdd.dao.MenuRepository;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static com.outdd.constants.Constants.HTTP_RES_CODE_200;

/*
 * TODO: 菜单实现
 * @author VAIE
 * @date: 2019/4/30-16:17
 * @version v1.0
 */
@RestController
public class MenuApiServiceImpl extends BaseApiService implements MenuApiService {
    @Resource
    MenuRepository menuRepository;

    @Override
    public ResponseBase findMenusByUserId(Integer id) {
        ResponseBase responseBase = setResultError("非法错误");
        List<Menu> menuList = menuRepository.findMenusByUserId(id);

        JSONArray menuHelps = analysisMenuToJson(excludeMenuTypethree(menuList));

        responseBase = setResult(HTTP_RES_CODE_200,"menusInfo", menuHelps);
        return responseBase;
    }
    public List<Menu> excludeMenuTypethree(List<Menu> menuList){
        List<Menu> menus = new ArrayList<>();
        for(Menu menu:menuList){
            if(!menu.getMenuType().equals("3")){
                menu.setMenus(excludeMenuTypethree(menu.getMenus()));
                menus.add(menu);
            }
        }
        return menus;
    }
    @Override
    public ResponseBase findMenus(PageHelp page, Menu entity) {
        Sort.Direction sort =  Sort.Direction.ASC;
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("menuName", ExampleMatcher.GenericPropertyMatchers.startsWith());//模糊查询匹配开头，即{username}%
//                .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
//                .withIgnorePaths("password")//忽略字段，即不管password是什么值都不加入查询条件
//                .withIgnorePaths("id");  //忽略属性：是否关注。因为是基本类型，需要忽略掉


        Example<Menu> example = Example.of(entity,matcher);
        Pageable pageable = PageRequest.of(page.current - 1, page.size, page.getOrderType(), page.sort);
        Page<Menu> pageInfo = menuRepository.findAll(example,pageable );
        return setResult(HTTP_RES_CODE_200,"Page<Menu>", pageInfo);
    }

    @Override
    public ResponseBase findSubMenuByParentId(Integer id) {
        if(id==null){

            return setResultError("menuId is not find");
        }
         List<Menu> menuList=menuRepository.findSubMenuByParentId(id);
        JSONArray menuHelps = analysisMenuToJson(menuList);
        return setResult(HTTP_RES_CODE_200,"Menus<Menu>", menuHelps);
    }

    @Override
    public ResponseBase findSubMenuByParentId(String path) {
        if(path==null){
            return setResultError("menuId is not find");
        }
        List<Menu> menuList=menuRepository.findSubMenuByPath(path);
        JSONArray menuHelps = analysisMenuToJson(menuList);
        return setResult(HTTP_RES_CODE_200,"Menus<Menu>", menuHelps);
    }

    public List<MenuHelp> analysisMenu(List<Menu> menus){
        List<MenuHelp> menuHelps =new ArrayList<>();
        for(Menu menu:menus){
            MenuHelp menuHelp =new MenuHelp();
            menuHelp.setIcon(menu.getMenuIcon());
            menuHelp.setTitle(menu.getMenuName());
            menuHelp.setPath(menu.getMenuUrl());
            if(null != menu.getMenus()){
                menuHelp.setChildren(analysisMenu(menu.getMenus()));
            }
            menuHelps.add(menuHelp);
        }

        return menuHelps;
    }

    public JSONArray analysisMenuToJson(List<Menu> menus){
        JSONArray menuHelps =new JSONArray();
        for(Menu menu:menus){
            JSONObject menuHelp =new JSONObject();
            if(null != menu.getMenuIcon()){
                menuHelp.put("icon", menu.getMenuIcon());
            }
            if(null != menu.getMenuName()){
                menuHelp.put("title", menu.getMenuName());
            }
            if(null != menu.getMenuUrl() && !"#".equals(menu.getMenuUrl())){
                menuHelp.put("path", menu.getMenuUrl());
            }
            if(null != menu.getMenuId()){
                menuHelp.put("menuId", menu.getMenuId());
            }
            if(null != menu.getMenus() && menu.getMenus().size() > 0){
                menuHelp.put("children", analysisMenuToJson(menu.getMenus()));
            }
            menuHelps.add(menuHelp);
        }

        return menuHelps;
    }
}
