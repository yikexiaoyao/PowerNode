package com.bjpowernode.entity;

public class Employee {
    private Integer emplId;

    private String emplName;

    private Integer emplAge;

    private Integer emplSex;

    private String emplPhone;

    public Integer getEmplId() {
        return emplId;
    }

    public void setEmplId(Integer emplId) {
        this.emplId = emplId;
    }

    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName == null ? null : emplName.trim();
    }

    public Integer getEmplAge() {
        return emplAge;
    }

    public void setEmplAge(Integer emplAge) {
        this.emplAge = emplAge;
    }

    public Integer getEmplSex() {
        return emplSex;
    }

    public void setEmplSex(Integer emplSex) {
        this.emplSex = emplSex;
    }

    public String getEmplPhone() {
        return emplPhone;
    }

    public void setEmplPhone(String emplPhone) {
        this.emplPhone = emplPhone == null ? null : emplPhone.trim();
    }
}