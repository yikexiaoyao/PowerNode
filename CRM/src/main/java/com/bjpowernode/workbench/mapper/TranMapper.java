package com.bjpowernode.workbench.mapper;

import com.bjpowernode.workbench.bean.PieVo;
import com.bjpowernode.workbench.bean.Tran;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author cty
 * @date 2021/11/5 19:55
 */
public interface TranMapper extends Mapper<Tran> {
    List<Map<String, Object>> barEcharts();

    List<PieVo> pieEcharts();
}
