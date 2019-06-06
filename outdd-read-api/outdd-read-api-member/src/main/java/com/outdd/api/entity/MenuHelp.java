package com.outdd.api.entity;

import lombok.Data;

import java.util.List;

/*
 * TODO: 菜单帮助类
 * @author VAIE
 * @date: 2019/5/16-14:14
 * @version v1.0
 */
@Data
public class MenuHelp {
    String title;
    String icon;
    String path;
    List<MenuHelp> children;
}
