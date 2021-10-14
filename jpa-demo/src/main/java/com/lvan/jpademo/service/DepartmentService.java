package com.lvan.jpademo.service;

import com.lvan.jpademo.entity.Department;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Lvan
 * @since 2021/10/13
 */
public interface DepartmentService {

    Page<Department> pageDepartments(int pageNum, int pageSize);

    List<Department> searchByName(String name);

    List<Department> listAllWithSort();

    Department updateDepartmentName(Integer id, String name);
}
