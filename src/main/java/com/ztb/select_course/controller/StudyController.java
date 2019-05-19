package com.ztb.select_course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.model.Student;
import com.ztb.select_course.model.Study;
import com.ztb.select_course.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/13 16:07
 * @Version 1.0
 */
@Controller
@RequestMapping("/student")
public class StudyController {
    @Autowired
    private StudyService studyService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/study")
    public String study(){
        return "/student/study";
    }

    @RequestMapping("/getAllStudy")
    @ResponseBody
    public RestResponse getAllStudy(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        Student student = (Student) request.getSession().getAttribute("student");
        PageHelper.startPage(page, 5);
        List<Study> list = studyService.getAllStudy(student.getId());
        return RestResponse.success().add("pageInfo", new PageInfo<>(list, 5));
    }
    @RequestMapping("/addStudy")
    @ResponseBody
    public RestResponse addStudy(){
        Student student = (Student) request.getSession().getAttribute("student");
        Integer id = student.getId();
        return studyService.addStudy(id)?RestResponse.success().add("data","新建成功"):RestResponse.fail().add("data","新建失败");
    }
    @RequestMapping("/modifyStudy/{studyId}")
    public String modifyStudy(@PathVariable Integer studyId){
        System.out.println(studyId);
        return "/student/modifyStudy";
    }
    @RequestMapping("/deleteStudy")
    @ResponseBody
    public RestResponse deleteStudy(Integer id){
        Student student = (Student) request.getSession().getAttribute("student");
        Integer sId = student.getId();
        return studyService.deleteStudy(id,sId)?RestResponse.success().add("data","删除成功"):RestResponse.fail().add("data","删除失败");
    }
    @RequestMapping("/submitStudy")
    @ResponseBody
    public RestResponse submitStudy(Integer id){
        Student student = (Student) request.getSession().getAttribute("student");
        String s = studyService.submitStudy(id, student);
        return RestResponse.success().add("data",s);
    }
}
