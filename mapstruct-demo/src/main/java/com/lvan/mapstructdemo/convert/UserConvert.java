package com.lvan.mapstructdemo.convert;

import com.lvan.mapstructdemo.dto.UserDTO;
import com.lvan.mapstructdemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Mapper
public interface UserConvert {

    /**
     * 转换
     */
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserDTO convert(User user);
}
