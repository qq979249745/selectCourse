package com.ztb.select_course.model;

import javax.validation.constraints.Pattern;

public class Professor {
    private Integer id;

    @Pattern(regexp = ".{5,10}",
            message = "教授账号格式错误")
    private String account;

    @Pattern(regexp = ".{5,16}",
            message = "教授密码格式错误")
    private String password;

    @Pattern(regexp = ".{2,20}",
            message = "教授名字格式错误")
    private String name;

    private Integer collegeId;

    @Pattern(regexp = "\\d{11}",
            message = "教授手机号格式错误")
    private String phone;

    private College college;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}