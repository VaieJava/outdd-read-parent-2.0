package com.outdd.api.literature.entity;

import com.outdd.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/*
 * 作品信息
 * @author VAIE
 * @date: 2019/6/11-16:44
 * @version v1.0
 */
@Table(name="book_info")
@Entity
@Data
@Proxy(lazy = false)
public class BookInfo extends BaseEntity implements Serializable {

    @Column
    private String uuid;

    @Column
    private String bookName;

    @Column
    private String intro;

    @Column
    private Long cateId;

    @Column
    private String author;

    @Column
    private byte[] bookImg;

//    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinTable(name = "volume_info", joinColumns = @JoinColumn(name = "volume_info_id", referencedColumnName = "id"))
//    private Set<VolumeInfo> volumeInfos;
//
//    @OneToOne(cascade= CascadeType.ALL)
//    @JoinColumn(name = "category_id", referencedColumnName = "id")
//    private Category category;
}
