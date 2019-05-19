package com.ztb.select_course.controller;

import com.ztb.select_course.model.CourseOffering;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.model.StudyProgram;
import com.ztb.select_course.service.StudyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/13 18:03
 * @Version 1.0
 */
@Controller
@RequestMapping("/student")
public class StudyProgramController {
    @Autowired
    private StudyProgramService studyProgramService;
    @RequestMapping("/modifyStudy/{studyId}/getAllStudyProgram")
    @ResponseBody
    public RestResponse getAllStudyProgram(@PathVariable Integer studyId){//根据学习计划查询已选的课程计划，应该还要传入学生id的
        List<StudyProgram> allStudyProgram = studyProgramService.getAllStudyProgram(studyId);
        return RestResponse.success().add("data",allStudyProgram);
    }
    @RequestMapping("/modifyStudy/{studyId}/getCourse")//查询可选的课程，去除学习计划中已有的课程计划id
    @ResponseBody
    public RestResponse getCourse(@PathVariable Integer studyId){
        //System.out.println(studyId);
        List<CourseOffering> courseOfferings = studyProgramService.getCourse(studyId);
        return RestResponse.success().add("data",courseOfferings);
    }
    @RequestMapping("/modifyStudy/{studyId}/add")//学生点击选课
    @ResponseBody
    public RestResponse addCourseProgram(@PathVariable Integer studyId,StudyProgram studyProgram){
        return studyProgramService.addCourseProgram(studyProgram)?
                RestResponse.success().add("data","选课成功"):RestResponse.fail().add("data","选课失败");
    }
    @RequestMapping("/modifyStudy/dropClass")
    @ResponseBody
    public RestResponse dropClass(Integer spId){
        return studyProgramService.dropClass(spId)?
                RestResponse.success().add("退选成功",spId):RestResponse.fail().add("退选失败",spId);
    }
}
