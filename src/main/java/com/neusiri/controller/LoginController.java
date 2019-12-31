package com.neusiri.controller;

import com.neusiri.response.Response;
import com.neusiri.util.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangdj
 * @date 2019/11/20
 */
@RestController
@Api(tags = {"登录测试"})
public class LoginController {


    @PostMapping("/judgeLogin")
    public Response judgeLogin(String token) {
        if (TokenUtil.verify(token)) {
            return Response.ok("用户已登录");
        } else {
            return Response.error("用户未登录或已过期");
        }
    }

    @PostMapping("login")
    public Response login(String username, String password){
        String token = TokenUtil.tokenTest(username, password);
        return Response.ok(token, "登录成功");
    }
}
