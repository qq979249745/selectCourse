package com.ztb.select_course.controller;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztb.select_course.model.Course;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/11 17:14
 * @Version 1.0
 */
@Controller
@RequestMapping("/registrar")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/course")
    public String courseManage() {
        return "/registrar/course";
    }


    @ResponseBody
    @RequestMapping("/getCourses")
    public RestResponse getCourses(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        PageHelper.startPage(page, 10);
        List<Course> list = courseService.getAll();
        return RestResponse.success().add("pageInfo", new PageInfo<>(list, 10));
    }

    @ResponseBody
    @RequestMapping("/getAllCourses")
    public RestResponse getAllCourses() {
        List<Course> list = courseService.getAll();
        return RestResponse.success().add("data", list);
    }

    @ResponseBody
    @RequestMapping("/getCourse")
    public RestResponse getCourse(Integer id) {
        Course Course = courseService.getCourse(id);
        return RestResponse.success().add("data", Course);
    }

    @PostMapping("/addCourse")
    @ResponseBody
    public RestResponse addCourse(@Valid Course course, BindingResult result) {
        System.out.println(course.getName());
        System.out.println(course.getCourseScore());
        System.out.println(course.getFee());
        System.out.println(course.getLevel());
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return courseService.addCourse(course) ? RestResponse.success().add("success", "添加成功")
                    : RestResponse.fail().add("error", "添加失败");
        }
    }

    @PostMapping("/modifyCourse")
    @ResponseBody
    public RestResponse modifyCourse(@Valid Course course, BindingResult result) {
        if (result.hasErrors()) {
            return RestResponse.fail().add("error", result.getAllErrors().get(0).getDefaultMessage());
        } else {
            return courseService.modifyCourse(course) ? RestResponse.success().add("success", "修改成功")
                    : RestResponse.fail().add("error", "修改失败");
        }
    }

    @GetMapping("/deleteCourse")
    @ResponseBody
    public RestResponse deleteCourse(Integer id) {
        return courseService.deleteCourse(id) ? RestResponse.success().add("message", "删除成功")
                : RestResponse.fail().add("message", "删除失败");
    }
}
