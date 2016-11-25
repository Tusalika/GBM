package com.yang.vo;

import java.io.Serializable;

/**
 * Created by Adminitster on 2016/11/15.
 */
public class TestUser implements Serializable {
    private int id;
    private String User_name;
    private String pwd;
    private String depart;
    private String sex;
    private String User_no;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_no() {
        return User_no;
    }

    public void setUser_no(String user_no) {
        User_no = user_no;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
