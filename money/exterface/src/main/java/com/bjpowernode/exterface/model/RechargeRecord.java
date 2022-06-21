package com.bjpowernode.exterface.model;

import java.io.Serializable;
import java.util.Date;

public class RechargeRecord implements Serializable {
    private Integer id;

    private Integer uid;

    private String rechargeNo;

    private String rechargeStatus;

    private Double rechargeMoney;

    private Date rechargeTime;

    private String rechargeDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRechargeNo() {
        return rechargeNo;
    }

    public void setRechargeNo(String rechargeNo) {
        this.rechargeNo = rechargeNo;
    }

    public String getRechargeStatus(String s) {
        return rechargeStatus;
    }

    public void setRechargeStatus(String rechargeStatus) {
        this.rechargeStatus = rechargeStatus;
    }

    public Double getRechargeMoney() {
        return this.rechargeMoney;
    }

    public void setRechargeMoney(Double rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeDesc() {
        return rechargeDesc;
    }

    public void setRechargeDesc(String rechargeDesc) {
        this.rechargeDesc = rechargeDesc;
    }

    @Override
    public String toString() {
        return "RechargeRecord{" +
                "id=" + id +
                ", uid=" + uid +
                ", rechargeNo='" + rechargeNo + '\'' +
                ", rechargeStatus='" + rechargeStatus + '\'' +
                ", rechargeMoney=" + rechargeMoney +
                ", rechargeTime=" + rechargeTime +
                ", rechargeDesc='" + rechargeDesc + '\'' +
                '}';
    }
}