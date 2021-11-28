package com.lvan.mapstructdemo.dto;

import lombok.Data;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Data
public class UserDTO {

    private Integer id;
    private String username;
    private String name;
    private String userType;
    private String street;
    private String city;
}
