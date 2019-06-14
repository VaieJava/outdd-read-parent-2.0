package com.outdd.api.literature.entity;

import com.outdd.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/*
 * 卷信息
 * @author VAIE
 * @date: 2019/6/11-16:46
 * @version v1.0
 */
@Table(name="volume_info")
@Entity
@Data
@Proxy(lazy = false)
public class VolumeInfo  extends BaseEntity implements Serializable {

    @Column
    private String uuid;

    @Column
    private String volumeName;

    @Column
    private Integer volumeNum;

    @Column
    private Long bookId;

    @Column
    private Integer totalVolume;

    @Column
    private Integer wordsCount;
}
