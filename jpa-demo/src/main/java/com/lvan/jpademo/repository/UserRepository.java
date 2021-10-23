package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author Lvan
 * @since 2021/10/9
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

    User findByName(String name);
}
