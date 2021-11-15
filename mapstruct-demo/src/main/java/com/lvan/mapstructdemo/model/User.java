package com.lvan.mapstructdemo.model;

import lombok.Data;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Data
public class User {

    private Integer id;
    private String username;
    private Long createTime;
    private Long updateTime;
}
