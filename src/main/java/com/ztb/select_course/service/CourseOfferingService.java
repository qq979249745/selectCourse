package com.ztb.select_course.service;

import com.ztb.select_course.dao.CourseMapper;
import com.ztb.select_course.dao.CourseOfferingMapper;
import com.ztb.select_course.dao.ProfessorMapper;
import com.ztb.select_course.dao.SemMapper;
import com.ztb.select_course.model.CourseOffering;
import com.ztb.select_course.model.CourseOfferingExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 20:00
 * @Version 1.0
 */
@Service
public class CourseOfferingService {
    @Autowired
    private CourseOfferingMapper courseOfferingMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ProfessorMapper professorMapper;
    @Autowired
    private SemMapper semMapper;
    public boolean addCourseOffering(CourseOffering courseOffering) {
        int i = courseOfferingMapper.insertSelective(courseOffering);
        return i>0;
    }
    public List<CourseOffering> getAllCourseOffering(Integer pid){
        CourseOfferingExample courseOfferingExample = new CourseOfferingExample();
        courseOfferingExample.createCriteria().andProfessorIdEqualTo(pid);
        List<CourseOffering> courseOfferings = courseOfferingMapper.selectByExample(courseOfferingExample);
        for (CourseOffering courseOffering : courseOfferings) {
            courseOffering.setCourse(courseMapper.selectByPrimaryKey(courseOffering.getCourseId()));
            courseOffering.setProfessor(professorMapper.selectByPrimaryKey(courseOffering.getProfessorId()));
            courseOffering.setSem(semMapper.selectByPrimaryKey(courseOffering.getSemId()));
            courseOffering.setPreCoures(courseMapper.selectByPrimaryKey(courseOffering.getPrerequisite()));
        }
        return courseOfferings;
    }

    public boolean modifyPreCourse(CourseOffering courseOffering) {
        int i = courseOfferingMapper.updateByPrimaryKeySelective(courseOffering);
        return i>0;
    }
}
