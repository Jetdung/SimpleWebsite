package com.yzd.classes;

public class User {                             //用户类
    String name;
    String pwd;
    int type;
    public User(){
    }
    public User(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
