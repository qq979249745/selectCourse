package com.ztb.select_course.service;

import com.ztb.select_course.dao.StudentMapper;
import com.ztb.select_course.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 11:13
 * @Version 1.0
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public boolean addStudent(Student student){
        int i = studentMapper.insertSelective(student);
        return i>0;
    }

    public List<Student> getAll() {
        return studentMapper.selectByExample(null);
    }

    public Student getStudent(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public boolean modifyStudent(Student student) {
        int i = studentMapper.updateByPrimaryKey(student);
        return i>0;
    }

    public boolean deleteStudent(Integer id) {
        int i = studentMapper.deleteByPrimaryKey(id);
        return i>0;
    }
}
