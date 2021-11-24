package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Counter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lvan
 * @date 2021/11/24
 */
@Repository
public interface CounterRepository extends JpaRepository<Counter, Integer> {

//    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
//    Optional<Counter> findById(Integer id);
}
