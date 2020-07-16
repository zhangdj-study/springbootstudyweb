package com.neusiri.service;

import com.neusiri.mapper.DepartmentMapper;
import com.neusiri.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 不指定CacheManager时，使用默认的CacheManager 即@Primary标注的实验
 * @author zhangdj
 * @date 2020-07-10 14:48
 */
@Service
@CacheConfig(cacheManager = "departmentCacheManager")
public class DepartmentService {

    private DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentService(DepartmentMapper departmentMapper){
        this.departmentMapper = departmentMapper;
    }

    @Cacheable(value = "department")
    public Department queryById(Long id){
        return departmentMapper.queryById(id);
    }
}
