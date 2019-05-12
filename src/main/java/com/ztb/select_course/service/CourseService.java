package com.ztb.select_course.service;

import com.ztb.select_course.dao.CourseMapper;
import com.ztb.select_course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean addCourse(Course course){
        int i = courseMapper.insertSelective(course);
        return i>0;
    }

    public List<Course> getAll() {
        return courseMapper.selectByExample(null);
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
}
