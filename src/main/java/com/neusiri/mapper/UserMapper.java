package com.neusiri.mapper;

import com.neusiri.model.UserDO;
import org.apache.ibatis.annotations.*;

/**
 * @author zhangdj
 * @date 2020-07-02 11:24
 */
@Mapper
public interface UserMapper {

    /**
     * 插入
     * keyProperty = "id" 可以不写
     * @param userDO 实体
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into t_user(name) values(#{name})")
    void insert(UserDO userDO);

    /**
     * 查询单个
     * @param id 唯一标识
     * @return
     */
    @Select("select * from t_user where id = #{id}")
    UserDO queryById(Long id);

    /**
     * 更新
     * @param userDO
     */
    @Update("update t_user set name = #{name},user_address = #{userAddress} where id = #{id}")
    void update(UserDO userDO);

    /**
     * 根据名字获取
     * @param name
     * @return
     */
    @Select("select * from t_user where name = #{name}")
    UserDO getByName(String name);
}
