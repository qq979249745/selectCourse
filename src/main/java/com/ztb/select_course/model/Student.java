package com.ztb.select_course.model;

import javax.validation.constraints.Pattern;

public class Student {
    private Integer id;

    @Pattern(regexp = ".{5,10}",
            message = "学生账号格式错误")
    private String account;

    @Pattern(regexp = ".{5,16}",
            message = "学生密码格式错误")
    private String password;

    @Pattern(regexp = ".{2,16}",
            message = "姓名")
    private String name;


    private Integer collegeId;

    @Pattern(regexp = ".{1,100}",
            message = "学生地址格式错误")
    private String address;

    @Pattern(regexp = "\\d{4}-\\d{1,2}-\\d{1,2}",
            message = "日期格式错误")
    private String birthday;

    @Pattern(regexp = "\\d{11}$",
            message = "手机号格式错误")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}