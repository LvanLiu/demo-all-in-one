package com.lvan.mapstructdemo.convert;

import com.lvan.mapstructdemo.annotation.ToPersistEntity;
import com.lvan.mapstructdemo.dto.UserDTO;
import com.lvan.mapstructdemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

    /**
     * 转换
     */
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(source = "address", target = ".")
//    @Mapping(source = "user.address.street", target = "street")
    @Mapping(source = "type", target = "userType")
    UserDTO toUserDTO(User user);

    @ToPersistEntity
    User toPersistUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO, @MappingTarget User user);
}
