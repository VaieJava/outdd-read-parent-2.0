package com.outdd.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.outdd.constants.EntityConstants;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.SimpleTimeZone;

/*
 * 实体类 - 基类
 * @author VAIE
 * @date: 2019/6/10-10:21
 * @version v1.0
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 删除标记
     */
    @Column(nullable=false,length=1)
    private Integer isDel = EntityConstants.IS_DEL_NO;
    /**
     * 启动标记
     */
    @Column(nullable=false,length=1)
    private Integer isEnable = EntityConstants.IS_ENABLE_NO;
    /**
     * 备注
     */
    @Column(nullable=false,length=255)
    private String remarks;
    /**
     * 创建者
     */
    @Column(nullable=false)
    private Long createBy;
    /**
     * 更新者
     */
    @Column(nullable=false)
    private Long updateBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable=false)
    private Date createTime;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(nullable=false)
    private Date updateTime;
}
