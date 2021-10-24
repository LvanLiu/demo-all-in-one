package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(length = 16)
    private String name;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;

    @CreatedBy
    private Integer createBy;

    @LastModifiedBy
    private Integer updateBy;

    @Version
    private Integer version;
}
