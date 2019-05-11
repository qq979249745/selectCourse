package com.ztb.select_course;

import com.ztb.select_course.dao.CollegeMapper;
import com.ztb.select_course.dao.ProfessorMapper;
import com.ztb.select_course.model.Professor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectCourseApplicationTests {
    @Autowired
    private ProfessorMapper professorMapper;
    @Test
    public void contextLoads() {
       /* for (int i = 0; i < 200; i++) {
            Professor professor = new Professor();
            professor
        }
        professorMapper.insertSelective()*/
    }

}
