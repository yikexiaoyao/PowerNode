package com.bjpowernode.exterface.service;

import com.bjpowernode.common.utils.PageModel;
import com.bjpowernode.exterface.model.LoanInfo;

import java.util.List;
import java.util.Map;

/**
 * 产品业务接口
 *
 * @author cty
 * @date 2021/12/15 19:16
 */
public interface LoanInfoService {
    /**
     * 动力金融网历史年化收益率: 产品平均利率
     */
    double getLoanInfoHistoryRateAvg();

    /**
     * 首页：根据类型和数量查询产品信息
     */
    List<LoanInfo> getLoanInfoByTypeAndNums(Map<String, Object> map);

    /**
     * 查询总记录数
     */
    Long getLoanInfoCountByType(Integer ptype);

    /**
     * 列表：根据类型和分页模型 查询产品信息
     */
    List<LoanInfo> getLoanInfoByTypeAndPageModel(Integer ptype, PageModel pageModel);

    /**
     * 产品详情
     */
    LoanInfo getLoanInfoById(Integer loanId);
}
