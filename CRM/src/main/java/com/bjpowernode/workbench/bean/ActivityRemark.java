package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/10/30 15:12
 */
@Table(name = "t_activity_remark")
@NameStyle(Style.normal)
@Data
public class ActivityRemark {
    @Id
    private String id;
    private String noteContent;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;
    private String editFlag;
    private String activityId;  //外键
    private String owner;   //所有者
    private String img; //备注头像
}
