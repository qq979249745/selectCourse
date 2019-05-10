package com.ztb.select_course.model;

public class CourseOffering {
    private Integer id;

    private Integer semId;

    private Integer courseId;

    private Integer professorId;

    private Integer prerequisite;

    private Integer orderNum;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    public Integer getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Integer prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}