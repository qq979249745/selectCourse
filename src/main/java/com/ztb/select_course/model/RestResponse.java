package com.ztb.select_course.model;

import java.util.HashMap;

/**
 * @Author: 16201533
 * @Date: 2019/5/10 14:10
 * @Version 1.0
 */
public class RestResponse {
    //状态码 100代表成功，200代表失败
    private int code;
    //提示信息
    private String msg;
    //发送给用户的数据
    private HashMap<String,Object> extend=new HashMap<>();

    public static RestResponse success(){
        RestResponse msg=new RestResponse();
        msg.setCode(100);
        msg.setMsg("处理成功");
        return msg;
    }

    public static RestResponse fail(){
        RestResponse msg=new RestResponse();
        msg.setCode(200);
        msg.setMsg("处理失败");
        return msg;
    }

    public RestResponse add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(HashMap<String, Object> extend) {
        this.extend = extend;
    }
}
