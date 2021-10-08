package com.lvan.jpademo.crud.repository;

import com.lvan.jpademo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lvan
 * @date 2021/10/8
 */
@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
