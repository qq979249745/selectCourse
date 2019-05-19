package com.ztb.select_course.service;

import com.ztb.select_course.dao.SemMapper;
import com.ztb.select_course.dao.StudentMapper;
import com.ztb.select_course.dao.StudyMapper;
import com.ztb.select_course.dao.StudyProgramMapper;
import com.ztb.select_course.model.*;
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
    @Autowired
    private StudyProgramMapper studyProgramMapper;
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

    public boolean deleteStudy(Integer id, Integer sId) {
        StudyExample studyExample = new StudyExample();
        studyExample.createCriteria().andIdEqualTo(id).andStuIdEqualTo(sId);
        return studyMapper.deleteByExample(studyExample)>0;
    }

    public String submitStudy(Integer studyId, Student student) {//学生提交学习计划
        List<StudyProgram> allStudyProgram = studyProgramService.getAllStudyProgram(studyId);
        College college = student.getCollege();
        int score=0;
        int primary=0,second=0;
        for (StudyProgram studyProgram : allStudyProgram) {
            if ("主选".equals(studyProgram.getState())){
                score+=studyProgram.getCourseOffering().getCourse().getCourseScore();
                primary++;
            }else {
                second++;
            }
            CourseOffering courseOffering = studyProgram.getCourseOffering();
            if (courseOffering.getPreCoures()!=null){
                for (StudyProgram program : allStudyProgram) {
                    if(program.getCourseOffering().getCourseId()==courseOffering.getPrerequisite())
                        break;
                }
                return "选了"+courseOffering.getPreCoures().getName()+"课程，必须选先决课程"+courseOffering.getCourse().getName();
            }
        }
        if (primary!=4){
            return "主选课程不是4门";
        }else if(second!=2){
            return "备选课程不是2门";
        }else if (college.getScore()>score){
            return "你需要的学分是："+college.getScore()+"，你所选的课程的总学分是"+score;
        }
        Study study = new Study();
        study.setStatus("已提交");
        int i = studyMapper.updateByPrimaryKeySelective(study);
        return i>0?"提交成功":"提交失败";
    }
}
