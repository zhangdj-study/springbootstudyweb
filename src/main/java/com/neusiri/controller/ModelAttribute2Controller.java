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
 * @date 2019/12/31 16:44
 */
@RestController
@RequestMapping("modelAttribute2")
@Api(tags = "ModelAttribute标注在有返回值的方法")
public class ModelAttribute2Controller {

    /**
     * @ModelAttribute 标注在有返回值的方法中，执行请求前会调用，将返回的实例放到model中，key为 testVO(类型名首字母变为小写)
     *
     * @ModelAttribute(value = "myVO") 可以指定放入model中的key值
     *
     * @return
     */
    @ModelAttribute(value = "myVO")
    public TestVO populateModel() {
        TestVO vo=new TestVO();
        vo.setId(1L);
        vo.setName("张三");
        return vo;
    }

    @PostMapping("/helloWorld3")
    public void helloWorld3(Model model) {
        System.out.println(model);
        System.out.println(model.asMap());
    }

}
