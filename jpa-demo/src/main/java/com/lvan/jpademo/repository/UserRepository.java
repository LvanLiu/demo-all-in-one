package com.lvan.jpademo.repository;

import com.lvan.jpademo.dto.EmailOnly;
import com.lvan.jpademo.dto.UserNameDto;
import com.lvan.jpademo.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
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
}

