package com.ztb.select_course.controll;

import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.model.User;
import com.ztb.select_course.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author: 16201533
 * @Date: 2019/5/6 21:45
 * @Version 1.0
 */

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResponse login(@Valid User user, BindingResult result) {

        if (result.hasErrors()){
            return RestResponse.fail().add("error",result.getAllErrors().get(0).getDefaultMessage());
        }else {
            return loginService.valid(user);
        }
    }
}
