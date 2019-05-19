package com.ztb.select_course.service;

import com.ztb.select_course.dao.*;
import com.ztb.select_course.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private StudyProgramMapper studyProgramMapper;
    public boolean addCourseOffering(CourseOffering courseOffering) {
        int i = courseOfferingMapper.insertSelective(courseOffering);
        return i>0;
    }
    public List<CourseOffering> getAllCourseOffering(Integer pid){
        CourseOfferingExample courseOfferingExample = new CourseOfferingExample();
        courseOfferingExample.createCriteria().andProfessorIdEqualTo(pid);
        return getAllCourseOffering(courseOfferingExample);
    }

    public boolean modifyPreCourse(CourseOffering courseOffering) {
        int i = courseOfferingMapper.updateByPrimaryKeySelective(courseOffering);
        return i>0;
    }
    public List<CourseOffering> getAllCourseOffering(CourseOfferingExample courseOfferingExample){
        List<CourseOffering> courseOfferings = courseOfferingMapper.selectByExample(courseOfferingExample);
        for (CourseOffering courseOffering : courseOfferings) {
            fillCourseOffering(courseOffering);
        }
        return courseOfferings;
    }
    public CourseOffering fillCourseOffering(CourseOffering courseOffering){
            courseOffering.setCourse(courseMapper.selectByPrimaryKey(courseOffering.getCourseId()));
            courseOffering.setProfessor(professorMapper.selectByPrimaryKey(courseOffering.getProfessorId()));
            courseOffering.setSem(semMapper.selectByPrimaryKey(courseOffering.getSemId()));
            courseOffering.setPreCoures(courseMapper.selectByPrimaryKey(courseOffering.getPrerequisite()));
        return courseOffering;
    }

    public boolean deleteOffering(Integer id) {
        return courseOfferingMapper.deleteByPrimaryKey(id)>0;
    }

    @Autowired
    private StudyMapper studyMapper;
    @Autowired
    private StudentService studentService;
    public List<Student> getSelectStudent(Integer id) {
        StudyProgramExample studyProgramExample = new StudyProgramExample();
        studyProgramExample.createCriteria().andCourseofferingIdEqualTo(id);
        List<StudyProgram> studyPrograms = studyProgramMapper.selectByExample(studyProgramExample);
        if (studyPrograms.size()>0){
            List<Integer> list=new ArrayList<>();
            for (StudyProgram studyProgram : studyPrograms) {
                list.add(studyProgram.getStudyId());
            }
            StudyExample studyExample=new StudyExample();
            studyExample.createCriteria().andIdIn(list);
            List<Study> studies = studyMapper.selectByExample(studyExample);
            list.clear();
            for (Study study : studies) {
                list.add(study.getStuId());
            }
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andIdIn(list);
            return studentService.getStudent(studentExample);
        }
        return null;
    }
}
