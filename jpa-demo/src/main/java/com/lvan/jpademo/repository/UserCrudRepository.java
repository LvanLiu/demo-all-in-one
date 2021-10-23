package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lvan
 * @since 2021/10/9
 */
@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
