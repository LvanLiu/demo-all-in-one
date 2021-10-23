package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * @author lvan
 * @date 2021/10/8
 */
@Proxy(lazy = false)
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(length = 16)
    private String name;

    private Integer age;

    @Column(length = 255)
    private String email;

    private Date date;
}
