package com.lvan.mapstructdemo.convert;

import com.lvan.mapstructdemo.dto.UserDTO;
import com.lvan.mapstructdemo.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lvan
 * @date 2021/11/9
 */
class UserConvertTest {

    @Test
    void toUserDTO_whenUsernameIsNotEmpty_thenSuccessConvert() {

        User user = new User();
        user.setUsername("test");

        UserDTO userDTO = UserConvert.INSTANCE.toUserDTO(user);

        assertThat(userDTO.getUsername()).isEqualTo("test");
    }

    @Test
    void toPersistUser_whenUseToPersistEntityAnnotation_thenShouldGenerateDataByAnnotation() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("test");

        User user = UserConvert.INSTANCE.toPersistUser(userDTO);

        assertThat(user).isNotNull();
        assertThat(user.getCreateTime()).isNotNull();
        assertThat(user.getUpdateTime()).isNotNull();
        assertThat(user.getId()).isNull();
        assertThat(user.getUsername()).isEqualTo("test");
    }
}