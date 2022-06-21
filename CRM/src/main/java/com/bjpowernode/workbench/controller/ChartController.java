package com.bjpowernode.workbench.controller;

import com.bjpowernode.workbench.bean.BarVo;
import com.bjpowernode.workbench.bean.PieVo;
import com.bjpowernode.workbench.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/14 17:13
 */
@RestController
public class ChartController {
    @Autowired
    private ChartService chartService;

    //柱状图
    @RequestMapping("/workbench/chart/barEcharts")
    public BarVo barEcharts(){
        return chartService.barEcharts();
    }

    //饼状图
    @RequestMapping("/workbench/chart/pieEcharts")
    public List<PieVo> pieEcharts(){
        return chartService.pieEcharts();
    }
}
