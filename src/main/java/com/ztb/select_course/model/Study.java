package com.ztb.select_course.model;

public class Study {
    private Integer id;

    private Integer stuId;

    private Student student;

    private Integer semId;

    private Sem sem;

    private String status;

    private Integer totalFee;

    private Integer orderNum;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Sem getSem() {
        return sem;
    }

    public void setSem(Sem sem) {
        this.sem = sem;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getSemId() {
        return semId;
    }

    public void setSemId(Integer semId) {
        this.semId = semId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }
}