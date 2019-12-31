package com.neusiri.controller;

import com.neusiri.model.TestVO;
import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangdj
 * @date 2019/12/31 17:57
 */
@Api(tags = "使用ModelAttribute组合对象,不指定对象名")
@RestController
@RequestMapping("modelAttribute3")
public class ModelAttribute3Controller {

    @ModelAttribute
    public TestVO populateModel() {
        TestVO vo=new TestVO();
        vo.setId(1L);
        return vo;
    }

    @PostMapping("/helloWorld")
    public void helloWorld(TestVO vv, Model model) {
        vv.setName("李四");
        System.out.println(vv);
    }
}
