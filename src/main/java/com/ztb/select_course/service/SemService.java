package com.ztb.select_course.service;

import com.ztb.select_course.dao.SemMapper;
import com.ztb.select_course.model.Sem;
import com.ztb.select_course.model.SemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: 16201533
 * @Date: 2019/5/12 17:35
 * @Version 1.0
 */
@Service
public class SemService {
    @Autowired
    private SemMapper semMapper;
    public Sem getTodaySem(){
        SemExample semExample = new SemExample();
        semExample.createCriteria().andSemLessThan(new Date());
        semExample.setOrderByClause("sem desc");
        List<Sem> sems = semMapper.selectByExample(semExample);
        if (sems.size()==0){
            Sem sem = new Sem();
            sem.setSem("2019-02-01");
            semMapper.insertSelective(sem);
            return sem;
        }
        return sems.get(0);
    }
}
