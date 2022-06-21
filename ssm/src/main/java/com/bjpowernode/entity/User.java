package com.bjpowernode.entity;

public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userRealName;

    private Integer userSex;

    private Integer userAge;

    private Integer userAgeBegin;

    private Integer userAgeEnd;

    private String msg;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserAgeBegin() {
        return userAgeBegin;
    }

    public void setUserAgeBegin(Integer userAgeBegin) {
        this.userAgeBegin = userAgeBegin;
    }

    public Integer getUserAgeEnd() {
        return userAgeEnd;
    }

    public void setUserAgeEnd(Integer userAgeEnd) {
        this.userAgeEnd = userAgeEnd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}