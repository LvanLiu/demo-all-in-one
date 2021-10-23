package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Lvan
 * @since 2021/10/23
 */
@SpringBootTest
class QueryByExampleExecutorTest {

    @Autowired
    private UserRepository userRepository;

    /**
     * 测试ExampleMatcher.matchingAll()方法
     */
    @Test
    void testExampleMatcherMatchingAll() {

        User user = new User();
        user.setName("test");
        user.setEmail("xxxx@qq.com");

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll();

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));

        assertThat(users).isNotNull();
    }


    /**
     * 测试ExampleMatcher.matchingAny()方法
     */
    @Test
    void testExampleMatcherMatchingAny() {

        User user = new User();
        user.setName("test");
        user.setEmail("xxxx@qq.com");

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny();

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));

        assertThat(users).isNotNull();
    }

    /**
     * 使用WithIncludeNullValues, 最终生成的SQL语句是: where xxx is null
     */
    @Test
    void testWithIncludeNullValues() {

        User user = new User();
        user.setName("test");
        user.setEmail("xxxx@qq.com");

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIncludeNullValues();

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));

        assertThat(users).isNotNull();
    }

    /**
     * 默认就是忽略空值的了,所以一般开发不需要额外指定
     */
    @Test
    void testWithIgnoreNullValues() {

        User user = new User();
        user.setName("test");
        user.setEmail("xxxx@qq.com");

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues();

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));

        assertThat(users).isNotNull();
    }

    @Test
    void testStringMatcher() {

        User user = new User();
        user.setName("test");

        //等值查询
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
//                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT);

        //模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));
        assertThat(users).isNotNull();
    }

    /**
     * 使用 GenericPropertyMatcher 可以指定特定字段的字符串匹配方式
     */
    @Test
    void testGenericPropertyMatcher() {

        User user = new User();
        user.setName("test");

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::startsWith);

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));
        assertThat(users).isNotNull();
    }

    @Test
    void testIgnorePaths() {

        User user = new User();
        user.setName("test");
        user.setEmail("xxxx@qq.com");

        //忽略email不进行匹配
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::startsWith)
                .withIgnorePaths("email");

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));
        assertThat(users).isNotNull();
    }

    @Test
    void testIgnoreCase() {

        User user = new User();
        user.setName("test");
        user.setEmail("xxxx@qq.com");

        //忽略email不进行匹配
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::startsWith)
                .withIgnoreCase();

        List<User> users = userRepository.findAll(Example.of(user, exampleMatcher));
        assertThat(users).isNotNull();
    }
}
