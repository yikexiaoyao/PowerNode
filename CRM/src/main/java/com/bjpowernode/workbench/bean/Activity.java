package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author cty
 * @date 2021/10/28 15:50
 */
@Table(name = "t_activity")
@NameStyle(Style.normal)
@Data
public class Activity {
    @Id
    private String id;
    private String owner;   // 外键
    private String name;
    private String startTime;
    private String endTime;
    private String cost;
    private String description;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;

    private List<ActivityRemark> activityRemarks;   //市场活动备注
}
