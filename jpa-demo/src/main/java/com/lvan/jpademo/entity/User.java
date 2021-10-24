package com.lvan.jpademo.entity;

import com.lvan.jpademo.enums.GenderEnum;
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

//    @TableGenerator(name = "table_sequences", table = "table_sequences", pkColumnName = "table_name", valueColumnName = "table_id")
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "table_sequences")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(length = 16)
    private String name;

    private Integer age;

    @Column(length = 255)
    private String email;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private Date date;

}
