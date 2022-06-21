package com.bjpowernode.workbench.service.impl;

import com.bjpowernode.workbench.bean.BarVo;
import com.bjpowernode.workbench.bean.PieVo;
import com.bjpowernode.workbench.mapper.TranMapper;
import com.bjpowernode.workbench.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author cty
 * @date 2021/11/14 17:16
 */
@Service
public class ChartServiceImpl implements ChartService {

    @Autowired
    private TranMapper tranMapper;

    @Override
    public BarVo barEcharts() {
        List<Map<String, Object>> maps = tranMapper.barEcharts();

        //存储标题
        List<String> titles = new ArrayList<>();
        //存贮y轴数据
        List<Long> values = new ArrayList<>();

        for (Map<String, Object> m : maps) {
            String stage = (String) m.get("stage");
            titles.add(stage);
            Long value = Long.parseLong(m.get("num") + "");
            values.add(value);
        }
        BarVo barVo = new BarVo();
        barVo.setTitles(titles);
        barVo.setValues(values);

        return barVo;
    }

    @Override
    public List<PieVo> pieEcharts() {
        return tranMapper.pieEcharts();
    }
}
