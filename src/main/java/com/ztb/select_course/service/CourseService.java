package com.ztb.select_course.service;

import com.ztb.select_course.dao.CourseMapper;
import com.ztb.select_course.model.Course;
import com.ztb.select_course.model.CourseExample;
import com.ztb.select_course.model.CourseOffering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 13:10
 * @Version 1.0
 */
@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CourseOfferingService courseOfferingService;
    public boolean addCourse(Course course){
        int i = courseMapper.insertSelective(course);
        return i>0;
    }

    public List<Course> getAll() {
        return courseMapper.selectByExample(null);
    }

    public List<Course> getAllNotIn(Integer pid) {
        CourseExample courseExample = new CourseExample();
        List<CourseOffering> allCourseOffering = courseOfferingService.getAllCourseOffering(pid);
        if (allCourseOffering.size()>0){
            List<Integer> list = new ArrayList<>();
            for (CourseOffering courseOffering : allCourseOffering) {
                list.add(courseOffering.getCourseId());
            }

            courseExample.createCriteria().andIdNotIn(list);
        }
        return courseMapper.selectByExample(courseExample);
    }

    public Course getCourse(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public boolean modifyCourse(Course course) {
        int i = courseMapper.updateByPrimaryKey(course);
        return i>0;
    }

    public boolean deleteCourse(Integer id) {
        int i = courseMapper.deleteByPrimaryKey(id);
        return i>0;
    }

    public List<Course> getAllCourses(Integer id) {
        CourseExample courseExample = new CourseExample();
        courseExample.createCriteria().andIdNotEqualTo(id);
        return courseMapper.selectByExample(courseExample);
    }
}
