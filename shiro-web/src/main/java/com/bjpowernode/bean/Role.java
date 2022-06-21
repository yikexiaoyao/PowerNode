package com.bjpowernode.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/12/9 14:58
 */
@Table(name = "t_role")
@NameStyle(Style.normal)
@Data
public class Role {
    @Id
    private String roleId;
    private String roleName;
}
