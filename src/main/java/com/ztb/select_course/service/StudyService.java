package com.ztb.select_course.service;

import com.ztb.select_course.dao.SemMapper;
import com.ztb.select_course.dao.StudentMapper;
import com.ztb.select_course.dao.StudyMapper;
import com.ztb.select_course.dao.StudyProgramMapper;
import com.ztb.select_course.model.Sem;
import com.ztb.select_course.model.Student;
import com.ztb.select_course.model.Study;
import com.ztb.select_course.model.StudyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/13 16:23
 * @Version 1.0
 */
@Service
public class StudyService {
    @Autowired
    private StudyMapper studyMapper;
    @Autowired
    private SemService semService;
    @Autowired
    private SemMapper semMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudyProgramService studyProgramService;
    public boolean addStudy(Integer stuId){
        Sem todaySem = semService.getTodaySem();
        Study study = new Study();
        study.setSemId(todaySem.getId());
        study.setStuId(stuId);
        int i = studyMapper.insertSelective(study);
        return i>0;
    }

    public List<Study> getAllStudy(Integer stuID) {
        StudyExample studyExample = new StudyExample();
        studyExample.createCriteria().andStuIdEqualTo(stuID);
        List<Study> studies = studyMapper.selectByExample(studyExample);
        for (Study study : studies) {
            study.setSem(semMapper.selectByPrimaryKey(study.getSemId()));
            study.setStudent(studentMapper.selectByPrimaryKey(study.getStuId()));
            study.setOrderNum(studyProgramService.getCountByStuId(study.getId()));
        }
        return studies;
    }
}
