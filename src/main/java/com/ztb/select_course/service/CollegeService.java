package com.ztb.select_course.service;

import com.ztb.select_course.dao.CollegeMapper;
import com.ztb.select_course.model.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/10 16:59
 * @Version 1.0
 */
@Service
public class CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    public boolean addCollege(College college){
        int i = collegeMapper.insertSelective(college);
        return i>0;
    }

    public List<College> getAll() {
        return collegeMapper.selectByExample(null);
    }

    public College getCollege(Integer id) {
        return collegeMapper.selectByPrimaryKey(id);
    }

    public boolean modifyCollege(College college) {
        int i = collegeMapper.updateByPrimaryKey(college);
        return i>0;
    }
}
