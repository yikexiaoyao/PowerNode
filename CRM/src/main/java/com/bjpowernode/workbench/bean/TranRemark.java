package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/11/5 19:53
 */
@Table(name = "t_tran_remark")
@NameStyle(Style.normal)
@Data
public class TranRemark {
    @Id
    private String id;
    private String noteContent;
    private String createBy;
    private String createTime;
    private String editBy;
    private String editTime;
    private String editFlag;
    private String tranId;
    private String img;
    private String owner;
}
