package com.lvan.jpademo.service;

import com.lvan.jpademo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Lvanim
 * @since 2021/10/10
 */
public interface UserService {

    User userRegister(User newUser);

    User fetchUser(Integer id);

    User userAgeGrow(Integer id);

    List<User> fetchAllUsers();

    List<User> fetchAllUsersBySortAge();

    Page<User> fetchUsersByPage(int pageNum, int pageSize);
}