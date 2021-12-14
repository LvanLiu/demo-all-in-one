package com.lvan.mapstructdemo.convert;

import com.lvan.mapstructdemo.annotation.ToPersistEntity;
import com.lvan.mapstructdemo.dto.AddressDTO;
import com.lvan.mapstructdemo.dto.UserDTO;
import com.lvan.mapstructdemo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author lvan
 * @date 2021/11/9
 */
@Mapper(componentModel = "spring", typeConversionPolicy = ReportingPolicy.IGNORE)
public interface UserConvert {

    /**
     * 转换
     */
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(source = "address", target = ".")
    @Mapping(source = "type", target = "userType")
    UserDTO toUserDTO(User user);

    @ToPersistEntity
    User toPersistUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO, @MappingTarget User user);

    /**
     * 多参数拷贝
     */
    @Mapping(source = "addressDTO", target = "address")
    User convert(UserDTO userDTO, AddressDTO addressDTO);

    /**
     * 多参数拷贝之拷贝部分数据
     */
    @Mapping(source = "addressDTO.street", target = "address.street")
    User convert1(UserDTO userDTO, AddressDTO addressDTO);
}
