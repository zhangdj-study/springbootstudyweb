package com.neusiri.repository;

import com.neusiri.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangdj
 * @date 2020-07-03 10:30
 * 继承JpaRepository 泛型分别为 实体类的类型和实体类主键的类型
 */
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
