package com.ztb.select_course.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 16201533
 * @Date: 2019/5/6 21:45
 * @Version 1.0
 */
@Controller
public class LoginController {


    @RequestMapping("/login")
    public String login() {

        return "login";
    }
}
