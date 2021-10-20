package com.lvan.jpademo.service.impl;

import com.lvan.jpademo.entity.Department;
import com.lvan.jpademo.repository.DepartmentRepository;
import com.lvan.jpademo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

/**
 * @author Lvan
 * @since 2021/10/13
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Page<Department> pageDepartments(int pageNum, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        return departmentRepository.listAll(pageRequest);
    }

    @Override
    public List<Department> searchByName(String name) {

        return departmentRepository.listByNameLike(name);
    }

    @Override
    public List<Department> listAllWithSort() {

        return departmentRepository.listAllAfterSortBy("sort");
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Department updateDepartmentName(Integer id, String name) {
        departmentRepository.update(id, name);
        return departmentRepository.getById(id);
    }

    @Override
    public Department fetchDepartmentById(Integer id) {

        Optional<Department> departmentOptional = departmentRepository.findOne(((root, query, criteriaBuilder) -> {
            Path<Object> objectPath = root.join("users", JoinType.LEFT).get("id");
            Predicate predicate = criteriaBuilder.equal(objectPath, id);
            return query.where(predicate).getRestriction();
        }));
        return departmentOptional.get();
    }
}
