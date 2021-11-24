package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Counter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author lvan
 * @date 2021/11/24
 */
@SpringBootTest
class CounterRepositoryTest {

    @Autowired
    private CounterRepository counterRepository;


    @Rollback(false)
    @Transactional
    @Test
    void currentCounter() {
        Optional<Counter> optional = counterRepository.findById(1);
        Counter counter = optional.get();
        counter.setCount(counter.getCount() + 1);
        counterRepository.save(counter);
    }


    @Transactional
    @Test
    void currentCounter2() {
        Optional<Counter> optional = counterRepository.findById(1);
        Counter counter = optional.get();
        counter.setCount(counter.getCount() + 1);
        counterRepository.save(counter);
    }

}