package com.ztb.select_course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: 16201533
 * @Date: 2019/5/10 15:28
 * @Version 1.0
 */
@Controller
public class RegistrarController {

    @RequestMapping("/registrar")
    public String registrar() {
        return "redirect:registrar/professor";
    }




}
