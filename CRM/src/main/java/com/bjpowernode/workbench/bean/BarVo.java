package com.bjpowernode.workbench.bean;

import lombok.Data;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/14 16:58
 */
@Data
public class BarVo {
    private List<String> titles;//横坐标标题
    private List<Long> values;//纵坐标数据
}
