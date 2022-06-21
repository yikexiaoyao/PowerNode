package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/1 10:39
 */
@Table(name = "t_contact")
@NameStyle(Style.normal)
@Data
public class Contact {
    @Id
    private String id;
    private String owner;   //所有者 外键
    private String source;
    private String customerId;  //客户ID
    private String fullname;    //
    private String appellation; //称呼 先生 女生
    private String email;
    private String mphone;
    private String job;
    private String birth;
    private String createBy;
    private String createTime;
    private String editBy;
    private String editTime;
    private String description;
    private String contactSummary;
    private String nextContactTime;
    private String address;

    private List<ContactRemark> contactRemarks;   //联系人备注
}
