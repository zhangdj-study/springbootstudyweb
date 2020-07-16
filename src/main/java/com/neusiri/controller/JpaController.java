package com.neusiri.controller;

import com.neusiri.model.Department;
import com.neusiri.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangdj
 * @date 2020-07-03 10:54
 */
@RestController
@RequestMapping("jpa")
public class JpaController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("department/{id}")
    public Department queryById(@PathVariable Long id){
        Department department = departmentRepository.findOne(id);
        return department;
    }

    @PostMapping("department")
    public Department insert(Department department){
        Department save = departmentRepository.save(department);
        return save;
    }
}
