package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
public class Role3 extends AbstractAuditable {

    @Column(length = 16)
    private String name;
}
