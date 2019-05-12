package com.ztb.select_course.model;

import javax.validation.constraints.Pattern;

public class Course {
    private Integer id;

    @Pattern(regexp = ".{2,10}",
            message = "课程名称格式错误")
    private String name;

    private Integer courseScore;

    private String level;

    private Integer fee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(Integer courseScore) {
        this.courseScore = courseScore;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}