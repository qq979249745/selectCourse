package com.ztb.select_course.controller;

import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.model.User;
import com.ztb.select_course.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Author: 16201533
 * @Date: 2019/5/6 21:45
 * @Version 1.0
 */

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public RestResponse login(@Valid User user, BindingResult result, HttpServletRequest request) {

        if (result.hasErrors()){
            return RestResponse.fail().add("error",result.getAllErrors().get(0).getDefaultMessage());
        }else {
            return loginService.valid(user,request);
        }
    }
    @RequestMapping("/registrar")
    public String registrar() {
        return "redirect:registrar/professor";
    }

    @RequestMapping("/professor")
    public String professor(){
        return "redirect:professor/courseOffering";
    }

    @RequestMapping("/student")
    public String student(){
        return "redirect:student/study";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "/";
    }
}
