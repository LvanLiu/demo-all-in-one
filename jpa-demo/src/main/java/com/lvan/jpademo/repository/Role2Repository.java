package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Role2;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Repository
public interface Role2Repository extends JpaRepositoryImplementation<Role2, Integer> {

}
