package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author Lvan
 * @since 2021/10/13
 */
@NamedEntityGraph(name = "Department.users", attributeNodes = {
        @NamedAttributeNode("users")
})
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
    private String name;
    private Integer sort;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "department_user_mapping",
            joinColumns = @JoinColumn(name = "department_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
//    @BatchSize(size = 3)
    private List<User> users;
}
