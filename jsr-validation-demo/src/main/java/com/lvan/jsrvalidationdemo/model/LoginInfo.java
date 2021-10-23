package com.lvan.jsrvalidationdemo.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lvan
 * @date 2021/10/22
 */
@Data
public class LoginInfo {
    @NotBlank
    private String account;
    @NotBlank
    private String password;
}
