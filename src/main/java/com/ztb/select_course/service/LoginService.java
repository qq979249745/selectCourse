package com.ztb.select_course.service;

import com.ztb.select_course.dao.RegistrarMapper;
import com.ztb.select_course.dao.StudentMapper;
import com.ztb.select_course.model.Registrar;
import com.ztb.select_course.model.RegistrarExample;
import com.ztb.select_course.model.RestResponse;
import com.ztb.select_course.model.User;
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
                    return RestResponse.success().add("success","registrar");
                }
                break;
            case "professor":

            case "student":
        }
        return RestResponse.fail().add("error","账号或密码错误");
    }
}
