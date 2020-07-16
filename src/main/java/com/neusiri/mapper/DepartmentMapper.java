package com.neusiri.mapper;

import com.neusiri.model.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhangdj
 * @date 2020-07-10 14:46
 */
@Mapper
public interface DepartmentMapper {

    /**
     * 详情
     * @param id
     * @return
     */
    @Select("select * from t_department where id = #{id}")
    Department queryById(Long id);
}
