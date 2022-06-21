package com.bjpowernode.dataservice.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.common.utils.PageModel;
import com.bjpowernode.dataservice.mapper.LoanInfoMapper;
import com.bjpowernode.exterface.model.LoanInfo;
import com.bjpowernode.exterface.service.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 产品业务实现类
 *
 * @author cty
 * @date 2021/12/15 19:20
 */
@Service(interfaceClass = LoanInfoService.class, version = "1.0.0", retries = 3, timeout = 20000)
@Component
public class LoanInfoServiceImpl implements LoanInfoService {
    @Autowired
    LoanInfoMapper loanInfoMapper;

    @Autowired
    RedisTemplate redisTemplate;

    //历史年化收益率: 产品平均利率
    @Override
    public double getLoanInfoHistoryRateAvg() {
        return loanInfoMapper.getLoanInfoHistoryRateAvg();
    }

    //首页：根据类型和数量查询产品信息
    @Override
    public List<LoanInfo> getLoanInfoByTypeAndNums(Map<String, Object> map) {
        return loanInfoMapper.getLoanInfosByTypeAndNums(map);
    }

    //查询总记录数
    @Override
    public Long getLoanInfoCountByType(Integer ptype) {
        return loanInfoMapper.getLoanInfoCountByType(ptype);
    }

    //列表：根据类型和分页模型 查询产品信息
    @Override
    public List<LoanInfo> getLoanInfoByTypeAndPageModel(Integer ptype, PageModel pageModel) {
        Map<String, Object> map = new HashMap<>();
        map.put("ptype", ptype);
        map.put("start", (pageModel.getCurrentPage() - 1) * pageModel.getPageSize());
        map.put("amount", pageModel.getPageSize());

        return loanInfoMapper.getLoanInfosByTypeAndNums(map);
    }

    //根据编号查询产品信息
    @Override
    public LoanInfo getLoanInfoById(Integer loanId) {
        return loanInfoMapper.selectByPrimaryKey(loanId);
    }
}
