package com.neusiri.controller;

import com.neusiri.mapper.UserMapper;
import com.neusiri.model.UserDO;
import com.neusiri.response.Response;
import com.neusiri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangdj
 * @date 2020-07-09 17:43
 */
@RequestMapping("user")
@RestController
public class UserController {

    private UserMapper userMapper;

    private UserService userService;

    @Autowired
    public UserController(UserMapper userMapper,UserService userService){
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PostMapping("{name}")
    public UserDO insert(@PathVariable String name){
        UserDO userDO = new UserDO();
        userDO.setName(name);
        userMapper.insert(userDO);
        return userDO;
    }

    @GetMapping("queryById/{id}")
    public Response<UserDO> queryById(@PathVariable Long id){
        UserDO userDO = userService.queryById(id);
        return Response.ok(userDO,"success");
    }

    @PutMapping("update")
    public UserDO update(UserDO userDO){
        userService.update(userDO);
        return userDO;
    }

    @DeleteMapping("delete")
    public String delete(Long id){
        userService.delete(id);
        return "success";
    }

    @GetMapping("getByName/{name}")
    public Response getByName(@PathVariable String name){
        UserDO userDO = userService.getByName(name);
        return Response.ok(userDO,"success");
    }
}
