package com.ztb.select_course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztb.select_course.model.*;
import com.ztb.select_course.service.CourseOfferingService;
import com.ztb.select_course.service.CourseService;
import com.ztb.select_course.service.SemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 16:25
 * @Version 1.0
 */
@RequestMapping("/professor")
@Controller
public class CourseOfferingController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private SemService semService;
    @Autowired
    private CourseOfferingService courseOfferingService;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("/courseOffering")
    public String professor(){
        return "professor/courseOffering";
    }

    @RequestMapping("/modifyOffering")
    public String modifyOffering(){
        return "professor/modifyOffering";
    }

    @ResponseBody
    @RequestMapping("/getCourses")//去除已在课程表的课程
    public RestResponse getCourses(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        Professor professor = (Professor) request.getSession().getAttribute("professor");
        PageHelper.startPage(page, 5);
        List<Course> list = courseService.getAllNotIn(professor.getId());
        return RestResponse.success().add("pageInfo", new PageInfo<>(list, 5));
    }

    @ResponseBody
    @RequestMapping("/getAllCourses")//用于查先决课程的，去除自身课程id
    public RestResponse getAllCourses(Integer id) {
        List<Course> list=courseService.getAllCourses(id);
        return RestResponse.success().add("data", list);
    }

    @ResponseBody
    @RequestMapping("/getSem")
    public RestResponse getSem() {
        Sem todaySem = semService.getTodaySem();
        return RestResponse.success().add("data", todaySem);
    }
    @ResponseBody
    @RequestMapping("/addCourseOffering")
    public RestResponse addCourseOffering(CourseOffering courseOffering){
        Professor professor = (Professor) request.getSession().getAttribute("professor");
        courseOffering.setOrderNum(0);
        courseOffering.setProfessorId(professor.getId());
        return courseOfferingService.addCourseOffering(courseOffering)?
                RestResponse.success().add("data","添加成功"):RestResponse.fail().add("data","添加失败");
    }
    @ResponseBody
    @RequestMapping("/getOfferings")
    public RestResponse getOfferings(@RequestParam(name = "page", defaultValue = "1") Integer page){
        Professor professor = (Professor) request.getSession().getAttribute("professor");
        PageHelper.startPage(page, 5);
        List<CourseOffering> allCourseOffering = courseOfferingService.getAllCourseOffering(professor.getId());
        return RestResponse.success().add("pageInfo", new PageInfo<>(allCourseOffering, 5));
    }
    @ResponseBody
    @RequestMapping("/modifyPreCourse")
    public RestResponse modifyPreCourse(CourseOffering courseOffering){
        return courseOfferingService.modifyPreCourse(courseOffering)
                ?RestResponse.success().add("data","修改成功"):RestResponse.fail().add("data","修改失败");
    }
}
