package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author lvan
 * @date 2021/10/8
 */
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
}
