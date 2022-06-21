package com.bjpowernode.setting.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/10/22 14:57
 */
@Table(name="t_user")
@NameStyle(Style.normal)
@Data
public class User {
    @Id
    private String id;
    private String loginAct;
    private String name;
    private String loginPwd;
    private String email;
    private String expireTime;
    private String lockState;
    private String deptNo;
    private String allowIps;
    private String createTime;
    private String createBy;
    private String editTime;
    private String editBy;
    private String img;
}
