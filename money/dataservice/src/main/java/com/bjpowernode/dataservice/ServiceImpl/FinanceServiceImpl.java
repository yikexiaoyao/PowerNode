package com.bjpowernode.dataservice.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.dataservice.mapper.FinanceAccountMapper;
import com.bjpowernode.exterface.model.FinanceAccount;
import com.bjpowernode.exterface.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 账户业务实现类
 *
 * @author cty
 * @date 2021/12/20 22:05
 */
@Service(interfaceClass = FinanceService.class, version = "1.0.0", retries = 3, timeout = 20000)
@Component
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    FinanceAccountMapper financeAccountMapper;

    /**
     * 登录后下拉：根据用户编号，查询余额
     */
    @Override
    public FinanceAccount getMoneyByUserId(Integer id) {
        return financeAccountMapper.getMoneyByUserId(id);
    }
}
