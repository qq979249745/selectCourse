package com.ztb.select_course.model;

public class College {
    private Integer id;

    private String collegeName;

    private String manager;

    private String address;

    private String degreeName;

    private Integer score;

    private Integer studyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName == null ? null : collegeName.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName == null ? null : degreeName.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(Integer studyTime) {
        this.studyTime = studyTime;
    }
}