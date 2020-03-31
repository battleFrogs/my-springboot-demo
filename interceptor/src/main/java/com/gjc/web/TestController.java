package com.gjc.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
// 第三种
//@CrossOrigin(origins = "*")
public class TestController {


    // 第四种
    @RequestMapping("/hello")
    @CrossOrigin(origins = "*")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/index")
    public String index(HttpServletResponse response) {
        // 第五种
        response.addHeader("Access-Allow-Control-Origin","*");
        return "index";
    }


}
