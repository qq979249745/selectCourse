package com.ztb.select_course.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @Author: 16201533
 * @Date: 2019/5/10 13:51
 * @Version 1.0
 */
public class User {
    @Pattern(regexp = "(^[a-zA-Z0-9]{3,16}$)|(^[\u2e80-\u9fff]{2,5}$)",
            message = "账号格式不正确")
    private String account;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "请选择账号类型")
    private String userType;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
