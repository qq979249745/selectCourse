package com.ztb.select_course.service;

import com.ztb.select_course.dao.StudyProgramMapper;
import com.ztb.select_course.model.StudyProgramExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 16201533
 * @Date: 2019/5/13 16:54
 * @Version 1.0
 */
@Service
public class StudyProgramService {
    @Autowired
    private StudyProgramMapper studyProgramMapper;
    public Integer getCountByStuId(Integer stuId){
        StudyProgramExample studyProgramExample = new StudyProgramExample();
        studyProgramExample.createCriteria().andStudyIdEqualTo(stuId);
        return studyProgramMapper.countByExample(studyProgramExample);
    }
}
