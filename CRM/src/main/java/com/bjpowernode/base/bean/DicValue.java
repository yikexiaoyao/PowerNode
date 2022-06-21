package com.bjpowernode.base.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author cty
 * @date 2021/11/4 16:47
 */
@Table(name = "t_dic_value")
@NameStyle(Style.normal)
@Data
public class DicValue {
    @Id
    private String id;
    private String value;
    private String text;
    private String orderNo;
    private String typeCode;
}
