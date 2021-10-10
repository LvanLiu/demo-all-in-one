package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lvan
 * @since 2021/10/9
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
