package com.ztb.select_course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.model.Student;
import com.ztb.select_course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 11:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/registrar")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    public String professorManage() {
        return "/registrar/student";
    }


    @ResponseBody
    @RequestMapping("/getStudents")
    public RestResponse getStudents(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        PageHelper.startPage(page, 10);
        List<Student> list = studentService.getAll();
        return RestResponse.success().add("pageInfo", new PageInfo<>(list, 10));
    }

    @ResponseBody
    @RequestMapping("/getStudent")
    public RestResponse getStudent(Integer id) {
        Student student = studentService.getStudent(id);
        return RestResponse.success().add("data", student);
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public RestResponse addStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return studentService.addStudent(student) ? RestResponse.success().add("success", "添加成功")
                    : RestResponse.fail().add("error", "添加失败");
        }
    }

    @PostMapping("/modifyStudent")
    @ResponseBody
    public RestResponse modifyStudent(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return studentService.modifyStudent(student) ? RestResponse.success().add("success", "修改成功")
                    : RestResponse.fail().add("error", "修改失败");
        }
    }

    @GetMapping("/deleteStudent")
    @ResponseBody
    public RestResponse deleteStudent(Integer id) {
        return studentService.deleteStudent(id) ? RestResponse.success().add("message", "删除成功")
                : RestResponse.fail().add("message", "删除失败");
    }
}
