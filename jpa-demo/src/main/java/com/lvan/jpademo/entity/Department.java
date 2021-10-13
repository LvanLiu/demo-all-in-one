package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author Lvan
 * @since 2021/10/13
 */
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Entity
@Table
public class Department {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private Integer parentId;

    @Column(length = 16)
    private String name;

    private Integer sort;
}
