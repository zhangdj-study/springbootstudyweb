package com.neusiri.controller;

import com.neusiri.model.Department;
import com.neusiri.response.Response;
import com.neusiri.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangdj
 * @date 2020-07-10 14:53
 */
@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("queryById/{id}")
    public Response queryById(@PathVariable Long id){
        Department department = departmentService.queryById(id);
        return Response.ok(department,"success");
    }
}
