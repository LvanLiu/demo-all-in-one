package com.lvan.jpademo.service.impl;

import com.lvan.jpademo.entity.Department;
import com.lvan.jpademo.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Lvan
 * @since 2021/10/13
 */
@SpringBootTest
class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    void pageDepartments() {

        Page<Department> departments = departmentService.pageDepartments(0, 10);
        assertThat(departments).isNotNull();
    }

    @Test
    void searchByName() {

        List<Department> departments = departmentService.searchByName("test");
        assertThat(departments).isNotNull();
    }

    @Test
    void listAllWithSort() {

        List<Department> departments = departmentService.listAllWithSort();
        assertThat(departments).isNotNull();
    }

    @Test
    void updateDepartmentName() {

        Department department = departmentService.updateDepartmentName(1, "update-test");
        assertThat(department).isNotNull();
    }
}