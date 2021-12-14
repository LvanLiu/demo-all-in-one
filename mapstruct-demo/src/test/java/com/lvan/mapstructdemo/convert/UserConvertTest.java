package com.lvan.mapstructdemo.convert;

import com.lvan.mapstructdemo.dto.AddressDTO;
import com.lvan.mapstructdemo.dto.UserDTO;
import com.lvan.mapstructdemo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lvan
 * @date 2021/11/9
 */
@SpringBootTest
class UserConvertTest {

    @Resource
    private UserConvert userConvert;

    /**
     * 测试属性简单转换
     */
    @Test
    void toUserDTO_whenUsernameIsNotEmpty_thenSuccessConvert() {

        User user = new User();
        user.setUsername("test");

        UserDTO userDTO = UserConvert.INSTANCE.toUserDTO(user);

        assertThat(userDTO.getUsername()).isEqualTo("test");
    }

    /**
     * 测试自定义注解的通用转换处理
     */
    @Test
    void toPersistUser_whenUseToPersistEntityAnnotation_thenSuccessConvert() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("test");

        User user = UserConvert.INSTANCE.toPersistUser(userDTO);

        assertThat(user).isNotNull();
        assertThat(user.getCreateTime()).isNotNull();
        assertThat(user.getUpdateTime()).isNotNull();
        assertThat(user.getId()).isNull();
        assertThat(user.getUsername()).isEqualTo("test");
    }

    /**
     * 测试源对象与实体对象字段命名不一样的复制
     */
    @Test
    void toUserDTO_whenCopyUserType_thenSuccessConvert() {

        User user = new User();
        user.setType("type");

        UserDTO userDTO = UserConvert.INSTANCE.toUserDTO(user);

        assertThat(userDTO.getUserType()).isEqualTo(user.getType());
    }

    /**
     * 测试子属性复制
     */
    @Test
    void toUserDTO_whenCopySubProperty_thenSuccessConvert() {

        User.Address address = new User.Address();
        address.setStreet("test");

        User user = new User();
        user.setAddress(address);

        UserDTO userDTO = UserConvert.INSTANCE.toUserDTO(user);

        assertThat(userDTO.getStreet()).isEqualTo(address.getStreet());
    }

    @Test
    void testMappingTarget() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("new name");

        User user = new User();
        user.setUsername("old name");

        UserConvert.INSTANCE.updateUser(userDTO, user);

        assertThat(user.getUsername()).isEqualTo(userDTO.getUsername());
    }

    @Test
    void testMappingWithMultipleParams() {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("new name");

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet("street");
        addressDTO.setCity("city");

        User user = UserConvert.INSTANCE.convert(userDTO, addressDTO);

        assertThat(user.getAddress().getStreet()).isNotEmpty();
    }
}