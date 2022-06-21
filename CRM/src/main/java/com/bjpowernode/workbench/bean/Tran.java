package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/5 19:49
 */
@Table(name = "t_tran")
@NameStyle(Style.normal)
@Data
public class Tran {
    @Id
    private String id;
    private String owner;
    private String money;
    private String name;
    private String expectedTime;
    private String customerId;  //客户外键
    private String stage;
    private String possibility; //可能性 描述交易进行到哪种阶段(程度)
    private String type;
    private String source;
    private String activityId;  //市场活动外键
    private String contactId;   //联系人外键
    private String createBy;
    private String createTime;
    private String editBy;
    private String editTime;
    private String description;
    private String contactSummary;
    private String nextContactTime;

    private List<TranHistory> tranHistories;    //阶段历史

    private List<TranRemark> tranRemarks;   //交易备注

    private  List<StageVo> stageVos;
}
