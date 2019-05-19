package com.ztb.select_course.model;

public class StudyProgram {
    private Integer id;

    private Integer studyId;

    private Integer courseofferingId;

    private CourseOffering courseOffering;

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudyId() {
        return studyId;
    }

    public void setStudyId(Integer studyId) {
        this.studyId = studyId;
    }

    public Integer getCourseofferingId() {
        return courseofferingId;
    }

    public void setCourseofferingId(Integer courseofferingId) {
        this.courseofferingId = courseofferingId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}