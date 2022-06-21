package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/11/1 19:09
 */
@Table(name = "t_contact_remark")
@NameStyle(Style.normal)
@Data
public class ContactRemark {
    @Id
    private String id;
    private String noteContent;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;
    private String editFlag;
    private String contactId;
    private String owner;   //所有者
    private String img; //备注头像
}
