package com.lvan.mapstructdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String type;
    private Address address;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @Data
    public static class Address {
        private String street;
        private String city;
    }
}
