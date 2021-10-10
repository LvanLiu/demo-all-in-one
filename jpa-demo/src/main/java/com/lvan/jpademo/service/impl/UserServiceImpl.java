package com.lvan.jpademo.service.impl;

import com.lvan.jpademo.entity.User;
import com.lvan.jpademo.exception.NotFoundException;
import com.lvan.jpademo.repository.UserRepository;
import com.lvan.jpademo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Lvan
 * @since 2021/10/10
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User userRegister(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User fetchUser(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() -> new NotFoundException("系统无此用户"));
    }

    @Override
    public User userAgeGrow(Integer id) {

        User user = fetchUser(id);
        user.setAge(user.getAge() + 1);
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> fetchAllUsersBySortAge() {
        Sort sort = Sort.by("age").descending();
        return userRepository.findAll(sort);
    }

    @Override
    public Page<User> fetchUsersByPage(int pageNum, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return userRepository.findAll(pageRequest);
    }
}