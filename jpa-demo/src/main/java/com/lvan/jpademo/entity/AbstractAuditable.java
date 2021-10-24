package com.lvan.jpademo.entity;

import com.lvan.jpademo.listen.DbOperateLogListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, DbOperateLogListener.class})
public abstract class AbstractAuditable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

    @CreatedBy
    private Integer createBy;

    @LastModifiedBy
    private Integer updateBy;
}
