package com.itheima.controller;

import com.itheima.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public  String testException() throws SysException {
        System.out.println("testException方法执行了");
        try {
            int i=1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("出现错误!");

        }return "success";
    }
}
