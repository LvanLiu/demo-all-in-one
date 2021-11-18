package com.lvan.jpademo.repository;

import com.lvan.jpademo.dto.EmailOnly;
import com.lvan.jpademo.dto.UserNameDto;
import com.lvan.jpademo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Lvan
 * @since 2021/10/9
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

    UserNameDto findByEmail(String email);

    EmailOnly findByName(String name);

    User findFirstByOrderByAgeDesc();

    List<User> findTop2ByOrderByAgeDesc();

    Stream<User> findByAge(Integer age);

    <T> Collection<T> findByDateGreaterThan(Date date, Class<T> type);

    @Query("select u from User u")
    Page<User> selectAll(Pageable pageable);

    /**
     * 注释 #pageable# 必须有。估计随着版本的变化这个会做优化。另外一种实现方法就是自己写两个查询方法，手动分页。
     */
    @Query(value = "select * from user /* #pageable# */",
            countQuery = "select count(*) from user",
            nativeQuery = true)
    Page<User> nativeSelectAll(Pageable pageable);

    @Modifying
    @Query(value = "update User u set u.name = :name where u.id = :id")
    void update(@Param("id") Integer id, @Param("name") String name);

    @Modifying(clearAutomatically = true)
    @Query(value = "update User u set u.name = :name where u.id = :id")
    void updateAndClear(@Param("id") Integer id, @Param("name") String name);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "update User u set u.name = :name where u.id = :id")
    void updateAndClearAndFlush(@Param("id") Integer id, @Param("name") String name);

    void deleteByName(@Param("name") String name);
}

