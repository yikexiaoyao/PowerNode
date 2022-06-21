package com.bjpowernode.workbench.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/2 10:11
 */
@Table(name = "t_customer")
@NameStyle(Style.normal)
@Data
public class Customer {
    @Id
    private String id;
    private String owner;
    private String name;
    private String website;
    private String phone;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;
    private String contactSummary;
    private String nextContactTime;
    private String description;
    private String address;

    private List<CustomerRemark> customerRemarks;   //客户备注
}
