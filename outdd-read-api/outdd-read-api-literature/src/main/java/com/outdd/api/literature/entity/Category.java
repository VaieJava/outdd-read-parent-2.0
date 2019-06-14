package com.outdd.api.literature.entity;

import com.outdd.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/*
 * 分类信息
 * @author VAIE
 * @date: 2019/6/10-10:27
 * @version v1.0
 */
@Table(name="category")
@Entity
@Data
@Proxy(lazy = false)
public class Category extends BaseEntity implements Serializable {

    @Column
    private Long subCateId;

    @Column(length=255)
    private String cateNameCn;

    @Column(length=255)
    private String cateNameEn;

    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "subCateId", referencedColumnName = "id")    //根据父级菜单ID，实现自关联（内部其实也就是一对多）
    private Set<Category> categorys;
}
