package com.lvan.jpademo.repository;

import com.lvan.jpademo.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lvan
 * @since 2021/10/13
 */
@Repository
public interface DepartmentRepository extends JpaRepositoryImplementation<Department, Integer> {

    @Query(value = "select d from Department d")
    Page<Department> listAll(Pageable pageable);

    @Query(value = "select d from Department d where d.name like %?1")
    List<Department> listByNameLike(String name);

    @Query(value = "select * from department order by ?1", nativeQuery = true)
    List<Department> listAllAfterSortBy(String sortField);

    @Query(value = "select d from Department d where d.id = :id")
    Department getByDepartmentId(@Param("id") Integer id);
}
