package com.lvan.mapstructdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private Integer id;
    private String username;
    private String name;
    private String userType;
    private String street;
    private String city;
}
