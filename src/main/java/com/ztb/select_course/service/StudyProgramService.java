package com.ztb.select_course.service;

import com.ztb.select_course.dao.CourseOfferingMapper;
import com.ztb.select_course.dao.StudyProgramMapper;
import com.ztb.select_course.model.CourseOffering;
import com.ztb.select_course.model.CourseOfferingExample;
import com.ztb.select_course.model.StudyProgram;
import com.ztb.select_course.model.StudyProgramExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/13 16:54
 * @Version 1.0
 */
@Service
public class StudyProgramService {
    @Autowired
    private StudyProgramMapper studyProgramMapper;
    @Autowired
    private CourseOfferingMapper courseOfferingMapper;
    @Autowired
    private CourseOfferingService courseOfferingService;

    public Integer getCountByStuId(Integer stuId) {
        StudyProgramExample studyProgramExample = new StudyProgramExample();
        studyProgramExample.createCriteria().andStudyIdEqualTo(stuId);
        return studyProgramMapper.countByExample(studyProgramExample);
    }

    public List<StudyProgram> getAllStudyProgram(Integer studyId) {
        StudyProgramExample studyProgramExample = new StudyProgramExample();
        studyProgramExample.createCriteria().andStudyIdEqualTo(studyId);
        List<StudyProgram> studyPrograms = studyProgramMapper.selectByExample(studyProgramExample);
        for (StudyProgram studyProgram : studyPrograms) {
            CourseOffering courseOffering = courseOfferingMapper.selectByPrimaryKey(studyProgram.getCourseofferingId());
            courseOfferingService.fillCourseOffering(courseOffering);
            studyProgram.setCourseOffering(courseOffering);
        }
        return studyPrograms;
    }

    public List<CourseOffering> getCourse(Integer studyId) {
        StudyProgramExample studyProgramExample = new StudyProgramExample();
        studyProgramExample.createCriteria().andStudyIdEqualTo(studyId);
        CourseOfferingExample courseOfferingExample = new CourseOfferingExample();
        List<StudyProgram> studyPrograms = studyProgramMapper.selectByExample(studyProgramExample);
        if (studyPrograms.size() > 0) {
            List<Integer> list = new ArrayList<>();
            for (StudyProgram studyProgram : studyPrograms) {
                list.add(studyProgram.getCourseofferingId());
            }
            courseOfferingExample.createCriteria().andIdNotIn(list);
        }
        return courseOfferingService.getAllCourseOffering(courseOfferingExample);
    }

    public boolean addCourseProgram(StudyProgram studyProgram) {
        int i = studyProgramMapper.insertSelective(studyProgram);
        return i > 0;
    }

    public boolean dropClass(Integer spId) {
        int i = studyProgramMapper.deleteByPrimaryKey(spId);
        return i > 0;
    }
}
