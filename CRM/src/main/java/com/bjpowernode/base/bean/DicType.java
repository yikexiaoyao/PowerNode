package com.bjpowernode.base.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/4 16:47
 */
@Table(name = "t_dic_type")
@NameStyle(Style.normal)
@Data
public class DicType {
    @Id
    private String code;
    private String name;
    private String description;

    private List<DicValue> dicValues;//字典对应的值
}
