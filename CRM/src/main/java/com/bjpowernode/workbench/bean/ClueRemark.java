package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/11/6 20:02
 */
@Table(name = "t_clue_remark")
@NameStyle(Style.normal)
@Data
public class ClueRemark {
    @Id
    private String id;
    private String noteContent;
    private String createBy;
    private String createTime;
    private String editBy;
    private String editTime;
    private String editFlag;
    private String clueId;
    private String owner;   //所有者
    private String img; //备注头像
}
