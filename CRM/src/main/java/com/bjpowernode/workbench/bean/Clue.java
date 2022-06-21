package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/4 15:57
 */
@Table(name = "t_clue")
@NameStyle(Style.normal)
@Data
public class Clue {
    @Id
    private String id;
    private String fullname;
    private String appellation;
    private String owner;
    private String company;
    private String job;
    private String email;
    private String phone;
    private String website;
    private String mphone;
    private String state;
    private String source;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;
    private String description;
    private String contactSummary;
    private String nextContactTime;
    private String address;

    //线索备注集合
    private List<ClueRemark> clueRemarks;

    //关联的市场活动
    private List<Activity> activities;
}
