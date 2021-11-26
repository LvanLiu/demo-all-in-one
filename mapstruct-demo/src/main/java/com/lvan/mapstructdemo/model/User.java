package com.lvan.mapstructdemo.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Data
public class User {

    private Integer id;
    private String username;
    private String type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
