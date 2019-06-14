package com.outdd.api.member.service;

import com.outdd.api.member.entity.Menu;
import com.outdd.base.ResponseBase;
import com.outdd.common.PageHelp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * TODO: 菜单api
 * @author VAIE
 * @date: 2019/4/30-16:13
 * @version v1.0
 */
@RequestMapping("/menu")
public interface MenuApiService {
    @GetMapping("/findMenusByUserId")
    public ResponseBase findMenusByUserId(@PathVariable(value="id") Integer id);

    public ResponseBase findMenus(PageHelp page,Menu entity);

    public ResponseBase findSubMenuByParentId(Integer id);

    public ResponseBase findSubMenuByParentId(String path);


}
