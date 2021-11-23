package com.lvan.jpademo.repository;

import cn.hutool.core.util.StrUtil;
import com.lvan.jpademo.entity.Department;
import com.lvan.jpademo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Lvan
 * @since 2021/10/23
 */
@SpringBootTest
class JpaSpecificationExecutorTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    void testSearchByCondition() {

        //模拟条件
        Department department = new Department();
        department.setName("test");
        department.setSort(1);
        department.setId(1);

        Date startDate = new Date();
        Date endDate = new Date();
        int userId = 1;

        List<Department> departments = departmentRepository.findAll(((root, query, criteriaBuilder) -> {
            //用来缓存多个条件
            List<Predicate> predicates = new ArrayList<>();

            //名称使用模糊查询
            if (StrUtil.isNotBlank(department.getName())) {
                Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + department.getName() + "%");
                predicates.add(predicate);
            }

            //等值查询
            if (Objects.nonNull(department.getId())) {
                Predicate predicate = criteriaBuilder.equal(root.get("id"), department.getId());
                predicates.add(predicate);
            }

            //使用 大于等于 查询
            if (Objects.nonNull(department.getSort())) {
                Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("sort"), department.getSort());
                predicates.add(predicate);
            }

            //根据时间区间查询
            if (Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
                Predicate predicate = criteriaBuilder.between(root.get("createDate"), startDate, endDate);
                predicates.add(predicate);
            }

            Predicate predicate = criteriaBuilder.equal(root.join("users").get("id"), userId);
            predicates.add(predicate);

            return query.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
        }));
    }
}
