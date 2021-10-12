package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lvan
 * @since 2021/10/9
 */
@Repository
public interface UserRepository extends JpaRepositoryImplementation<User, Integer> {

    List<User> findAllByName(String name, Sort sort);

    Page<User> findAllByName(String name, Pageable pageable);

    Slice<User> findAllByEmail(String email, Pageable pageable);

    User findFirstByOrderByAgeDesc();

    List<User> findTop2ByOrderByAgeDesc();
    
}
