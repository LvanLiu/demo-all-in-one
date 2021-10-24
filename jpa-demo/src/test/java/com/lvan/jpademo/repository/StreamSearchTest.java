package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@SpringBootTest
class StreamSearchTest {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Test
    void testFindByAge() {

        Stream<User> stream = userRepository.findByAge(18);
        Optional<User> userOptional = stream.findFirst();

        assertThat(userOptional.get()).isNotNull();
    }
}
