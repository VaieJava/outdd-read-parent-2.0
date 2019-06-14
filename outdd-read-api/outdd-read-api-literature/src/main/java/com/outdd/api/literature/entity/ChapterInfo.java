package com.outdd.api.literature.entity;

import com.outdd.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/*
 * 章节信息
 * @author VAIE
 * @date: 2019/6/11-16:48
 * @version v1.0
 */
@Table(name="chapter_info")
@Entity
@Data
@Proxy(lazy = false)
public class ChapterInfo  extends BaseEntity implements Serializable {
    @Column
    private String uuid;

    @Column
    private String chapterName;

    @Column
    private Long next;

    @Column
    private Long prev;

    @Column
    private Date updateTime;

    @Column
    private Long volumeId;

    @Column
    private Long wordsCount;

    @Column
    private Integer isfirst;

    @Column
    private Integer chapterNum;

    @Column
    private byte[] content;

    @Column
    private String tableName;

}
