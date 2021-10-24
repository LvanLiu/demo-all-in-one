package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Role;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Repository
public interface RoleRepository extends JpaRepositoryImplementation<Role, Integer> {
}
