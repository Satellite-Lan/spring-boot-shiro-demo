package com.mrlanwx.springbootshirodemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lanweixing
 * @Date: 2019/10/21 14:42
 * @Description:
 */
@RestController()
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String test(){
        return "hello test";
    }
}
