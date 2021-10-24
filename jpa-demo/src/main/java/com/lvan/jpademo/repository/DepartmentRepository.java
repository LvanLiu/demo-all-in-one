package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Department;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

/**
 * @author Lvan
 * @since 2021/10/13
 */
@Repository
public interface DepartmentRepository extends JpaRepositoryImplementation<Department, Integer> {

//    @EntityGraph(value = "Department.users")
//    List<Department> findAll();
}
