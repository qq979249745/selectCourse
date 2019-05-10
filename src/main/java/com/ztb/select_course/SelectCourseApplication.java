package com.ztb.select_course;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.ztb.select_course"})
@MapperScan(basePackages = "com.ztb.select_course.dao")
public class SelectCourseApplication {

    public static void main(String[] args) {

        SpringApplication.run(SelectCourseApplication.class, args);

    }

}
