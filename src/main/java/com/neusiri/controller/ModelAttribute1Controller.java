package com.neusiri.controller;

import io.swagger.annotations.Api;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangdj
 * @date 2019/12/31/031
 */
@RestController
@RequestMapping("modelAttribute1")
@Api(tags = "ModelAttribute标注在无返回值的方法")
public class ModelAttribute1Controller {

    /**
     * @ModelAttribute 标注无返回值的方法，在执行/helloWorld请求之前会调用
     *
     * @RequestParam 可以给请求参数设置默认值
     *
     * @param abc
     * @param model
     */
    @ModelAttribute
    public void populateModel(@RequestParam(defaultValue = "123") String abc, Model model) {
        model.addAttribute("attributeName", abc);
    }


    @PostMapping(value = "/helloWorld")
    public void helloWorld(Model model) {
        System.out.println(model.asMap());
    }
}
