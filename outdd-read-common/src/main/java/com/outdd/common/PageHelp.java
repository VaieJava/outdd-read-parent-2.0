package com.outdd.common;


import lombok.Data;
import org.springframework.data.domain.Sort;

/*
 * 分页帮助类
 * @author VAIE
 * @date: 2019/5/17-15:41
 * @version v1.0
 */
@Data
public class PageHelp {
    public Integer current = 1;
    public Integer size = 20;
    public String order = "asc";
    public String sort;
    Sort.Direction orderType;

    public Sort.Direction getOrderType() {
        if(order.equals("asc")){
            orderType = Sort.Direction.ASC;
        }else{
            orderType = Sort.Direction.DESC;
        }
        return orderType;
    }



}
