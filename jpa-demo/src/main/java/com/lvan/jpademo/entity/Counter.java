package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author lvan
 * @date 2021/11/24
 */
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Entity
@Table
public class Counter {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer count;

    @Version
    private Integer version;
}
