package com.lvan.mapstructdemo.convert;

import com.lvan.mapstructdemo.dto.UserDTO;
import com.lvan.mapstructdemo.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lvan
 * @date 2021/11/9
 */
class UserConvertTest {

    @Test
    void convert() {

        User user = new User();
        user.setId(1);
        user.setUsername("lvan");

        UserDTO userDTO = UserConvert.INSTANCE.convert(user);

        assertThat(userDTO.getUsername()).isNotEmpty();
    }
}