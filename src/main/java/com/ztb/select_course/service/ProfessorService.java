package com.ztb.select_course.service;

import com.ztb.select_course.dao.ProfessorMapper;
import com.ztb.select_course.model.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 10:20
 * @Version 1.0
 */
@Service
public class ProfessorService {
    @Autowired
    private ProfessorMapper professorMapper;
    public boolean addProfessor(Professor professor){
        int i = professorMapper.insertSelective(professor);
        return i>0;
    }

    public List<Professor> getAll() {
        return professorMapper.selectByExample(null);
    }

    public Professor getProfessor(Integer id) {
        return professorMapper.selectByPrimaryKey(id);
    }

    public boolean modifyProfessor(Professor college) {
        int i = professorMapper.updateByPrimaryKey(college);
        return i>0;
    }

    public boolean deleteProfessor(Integer id) {
        int i = professorMapper.deleteByPrimaryKey(id);
        return i>0;
    }
}
