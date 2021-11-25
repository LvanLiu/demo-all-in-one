package com.lvan.mapstructdemo.annotation;

import org.mapstruct.Mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 统一处理持久化实体的审计信息转换
 *
 * @author lvan
 * @date 2021/11/25
 */
@Retention(RetentionPolicy.CLASS)
@Mapping(target = "id", ignore = true)
@Mapping(target = "createTime", expression = "java(java.time.LocalDateTime.now())")
@Mapping(target = "updateTime", expression = "java(java.time.LocalDateTime.now())")
public @interface ToPersistEntity {
}
