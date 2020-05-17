package com.fzc.controller;

/*
 * @author fzc
 * @since 2020-05-10 10:53:32
*/

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "测试Controller", tags = { "测试访问接口" })
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
