package com.ztb.select_course.model;

public class StudyProgram {
    private Integer id;

    private Integer semId;

    private Integer stuId;

    private Integer courseId;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSemId() {
        return semId;
    }

    public void setSemId(Integer semId) {
        this.semId = semId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}