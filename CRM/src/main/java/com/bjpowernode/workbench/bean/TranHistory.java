package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/11/5 19:51
 */
@Table(name = "t_tran_history")
@NameStyle(Style.normal)
@Data
public class TranHistory {
    @Id
    private String id;
    private String stage;
    private String money;
    private String expectedTime;
    private String createTime;
    private String createBy;
    private String tranId;
    private String possibility;
}
