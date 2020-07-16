package com.neusiri.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2020-07-01 17:44
 */
@RestController
public class JdbcTemplateController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping("jdbc/test")
    public List<Map<String, Object>> test(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(maps);
        return maps;
    }
}
