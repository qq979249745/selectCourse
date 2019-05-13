package com.ztb.select_course.service;

import com.ztb.select_course.dao.ProfessorMapper;
import com.ztb.select_course.dao.RegistrarMapper;
import com.ztb.select_course.dao.StudentMapper;
import com.ztb.select_course.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/10 13:36
 * @Version 1.0
 */
@Service
public class LoginService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ProfessorMapper professorMapper;
    @Autowired
    private RegistrarMapper registrarMapper;
    public RestResponse valid(User user, HttpServletRequest request) {
        switch (user.getUserType()){
            case "registrar":
                RegistrarExample registrarExample=new RegistrarExample();
                RegistrarExample.Criteria rc = registrarExample.createCriteria();
                rc.andAccountEqualTo(user.getAccount());
                rc.andPasswordEqualTo(user.getPassword());
                List<Registrar> registrars = registrarMapper.selectByExample(registrarExample);
                if (registrars.size()>0){
                    request.getSession().setAttribute("user",user);
                    request.getSession().setAttribute("registrar",registrars.get(0));
                    return RestResponse.success().add("success","registrar");
                }
                break;
            case "professor":
                ProfessorExample professorExample=new ProfessorExample();
                ProfessorExample.Criteria pc = professorExample.createCriteria();
                pc.andAccountEqualTo(user.getAccount());
                pc.andPasswordEqualTo(user.getPassword());
                List<Professor> professors = professorMapper.selectByExample(professorExample);
                if (professors.size()>0){
                    request.getSession().setAttribute("user",user);
                    request.getSession().setAttribute("professor",professors.get(0));
                    return RestResponse.success().add("success","professor");
                }
                break;
            case "student":
                StudentExample studentExample=new StudentExample();
                StudentExample.Criteria sc = studentExample.createCriteria();
                sc.andAccountEqualTo(user.getAccount());
                sc.andPasswordEqualTo(user.getPassword());
                List<Student> students = studentMapper.selectByExample(studentExample);
                if (students.size()>0){
                    request.getSession().setAttribute("user",user);
                    request.getSession().setAttribute("student",students.get(0));
                    return RestResponse.success().add("success","student");
                }
                break;
        }
        return RestResponse.fail().add("error","账号或密码错误");
    }
}
