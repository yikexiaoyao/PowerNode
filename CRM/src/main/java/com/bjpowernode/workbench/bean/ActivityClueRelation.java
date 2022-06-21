package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/11/4 16:00
 */
@Table(name = "t_activity_clue_relation")
@NameStyle(Style.normal)
@Data
public class ActivityClueRelation {
    @Id
    private String id;
    private String activityId;
    private String clueId;
}
