package com.bjpowernode.workbench.service;

import com.bjpowernode.workbench.bean.BarVo;
import com.bjpowernode.workbench.bean.PieVo;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/14 17:13
 */
public interface ChartService {
    BarVo barEcharts();

    List<PieVo> pieEcharts();
}
