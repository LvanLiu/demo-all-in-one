package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/23
 */
@SpringBootTest
public class PagingAndSortingRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSortByAge() {

        //方式1(推荐这种,这种比较直观)
        //Sort sort = Sort.by(Sort.Direction.DESC, "age");
        //方式2
        Sort sort = Sort.by(Sort.Order.desc("age"));
        List<User> users = userRepository.findAll(sort);

        assertThat(users).isNotNull();
    }

    @Test
    void testSortByAgeAndName() {
        //方式1
//        Sort sort = Sort.by(Sort.Order.desc("age"), Sort.Order.desc("name"));
        //方式2
//        Sort sort = Sort.by(Sort.Direction.DESC, "age", "name");
        //方式3
        List<Sort.Order> orders = Sort.by(Sort.Order.desc("age")).and(Sort.Order.desc("name")).toList();
        Sort sort = Sort.by(orders);

        List<User> users =  userRepository.findAll(sort);
        assertThat(users).isNotNull();
    }

    @Test
    void testPage() {

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<User> users = userRepository.findAll(pageRequest);

        assertThat(users).isNotNull();
    }
}
