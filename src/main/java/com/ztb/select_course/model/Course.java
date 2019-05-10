package com.ztb.select_course.model;

public class Course {
    private Integer id;

    private String name;

    private Integer courseScore;

    private String rank;

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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}