package com.bjpowernode.workbench.service.impl;

import cn.hutool.core.util.StrUtil;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.DateTimeUtil;
import com.bjpowernode.base.util.UUIDUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import com.bjpowernode.workbench.bean.*;
import com.bjpowernode.workbench.mapper.*;
import com.bjpowernode.workbench.service.TranService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author cty
 * @date 2021/11/14 17:04
 */
@Service
public class TranServiceImpl implements TranService {

    @Autowired
    private TranMapper tranMapper;

    @Autowired
    private TranHistoryMapper tranHistoryMapper;
    
    @Autowired
    private TranRemarkMapper tranRemarkMapper;;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public List<Tran> list(int pageNum, int pageSize, Tran tran) {
        Example example = new Example(Tran.class);
        Example.Criteria criteria = example.createCriteria();

        //所有者模糊查询
        if (StrUtil.isNotEmpty(tran.getOwner())) {
            //根据用户的名字模糊查询出满足条件的用户
            Example example1 = new Example(User.class);
            example1.createCriteria().andLike("name", "%" + tran.getOwner() + "%");
            List<User> users = userMapper.selectByExample(example1);

            //定义一个集合，存储用户的主键
            List<String> ids = new ArrayList<>();
            for (User user : users) {
                ids.add(user.getId());
            }

            //根据查询出来的用户的外键查询交易
            criteria.andIn("owner", ids);
        }

        //交易查询
        if (StrUtil.isNotEmpty(tran.getName())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("name", "%" + tran.getName() + "%");
        }

        //客户名称模糊查询
        if (StrUtil.isNotEmpty(tran.getCustomerId())) {
            //根据用户的名字模糊查询出满足条件的用户
            Example example2 = new Example(Customer.class);
            example2.createCriteria().andLike("name", "%" + tran.getCustomerId() + "%");
            List<Customer> customers = customerMapper.selectByExample(example2);

            //定义一个集合，存储用户的主键
            List<String> ids = new ArrayList<>();
            for (Customer customer : customers) {
                ids.add(customer.getId());
            }

            //根据查询出来的用户的外键查询交易
            criteria.andIn("customerId", ids);
        }


        //阶段查询
        if (!"---请选择---".equals(tran.getStage())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andEqualTo("stage", tran.getStage());
        }

        //类型查询
        if (!"---请选择---".equals(tran.getType())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andEqualTo("type", tran.getType());
        }

        //来源查询
        if (!"---请选择---".equals(tran.getSource())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andEqualTo("source", tran.getSource());
        }

        //联系人查询
        if (StrUtil.isNotEmpty(tran.getContactId())) {
            //根据用户的名字模糊查询出满足条件的用户
            Example example3 = new Example(Contact.class);
            example3.createCriteria().andLike("fullname", "%" + tran.getContactId() + "%");
            List<Contact> contacts = contactMapper.selectByExample(example3);

            //定义一个集合，存储用户的主键
            List<String> ids = new ArrayList<>();
            for (Contact contact : contacts) {
                ids.add(contact.getId());
            }

            //根据查询出来的用户的外键查询交易
            criteria.andIn("contactId", ids);
        }

        //该行代码等同于 limit a,b 参数1:当前页码 参数2:每页记录数 a=(page-1)*pageSize,b
        PageHelper.startPage(pageNum, pageSize);
        //按发布时间降序排序
        example.setOrderByClause("createTime desc");

        List<Tran> trans = tranMapper.selectByExample(example);
        for (Tran tran1 : trans) {
            String customerId = tran1.getCustomerId();
            Customer customer = customerMapper.selectByPrimaryKey(customerId);
            tran1.setCustomerId(customer.getName());

            String owner = tran1.getOwner();
            User user = userMapper.selectByPrimaryKey(owner);
            tran1.setOwner(user.getName());

            String contactId = tran1.getContactId();
            Contact contact = contactMapper.selectByPrimaryKey(contactId);
            tran1.setContactId(contact.getFullname());
        }

        return trans;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.selectAll();
    }

    @Override
    public ResultVo saveOrUpdate(Tran tran, User user) {
        ResultVo resultVo = new ResultVo();
        //获取交易的主键
        String id = tran.getId();

        Example example1 = new Example(Customer.class);
        String customerName = tran.getCustomerId();
        example1.createCriteria().andEqualTo("name", customerName);
        Customer customer = customerMapper.selectOneByExample(example1);

        Example example2 = new Example(Activity.class);
        String activityName = tran.getActivityId();
        example2.createCriteria().andEqualTo("name", activityName);
        Activity activity = activityMapper.selectOneByExample(example2);

        Example example3 = new Example(Contact.class);
        String contactName = tran.getCustomerId();
        example3.createCriteria().andEqualTo("fullname", contactName);
        Contact contact = contactMapper.selectOneByExample(example3);

        if (id == null) {
            //添加
            //主键
            if (customer == null) {
                customer = new Customer();
                customer.setId(UUIDUtil.uuid());
                customer.setOwner(tran.getOwner());
                customer.setName(tran.getCustomerId());
                tran.setContactId(customer.getId());
                customer.setCreateTime(DateTimeUtil.getSysTime());
                customer.setCreateBy(user.getName());
                customerMapper.insertSelective(customer);
            }
            if (activity == null) {
                activity.setId(UUIDUtil.uuid());
                activity.setOwner(tran.getOwner());
                activity.setName(tran.getActivityId());
                tran.setActivityId(activity.getId());
                activity.setCreateTime(DateTimeUtil.getSysTime());
                activity.setCreateBy(user.getName());
                activityMapper.insertSelective(activity);
            }
            if (contact == null) {
                contact.setId(UUIDUtil.uuid());
                contact.setCustomerId(customer.getId());
                contact.setOwner(tran.getOwner());
                contact.setFullname(tran.getContactId());
                tran.setContactId(contact.getId());
                contact.setCreateTime(DateTimeUtil.getSysTime());
                contact.setCreateBy(user.getName());
                contactMapper.insertSelective(contact);
            }
            tran.setId(UUIDUtil.uuid());
            tran.setCustomerId(customer.getId());
            tran.setCreateTime(DateTimeUtil.getSysTime());
            tran.setCreateBy(user.getName());
            int count = tranMapper.insertSelective(tran);
            if (count == 0) {
                throw new CrmException(CrmEnum.TRAN_SAVE);
            }
            resultVo.setMessage("添加交易成功");
        } else {
            //修改
            if (customer == null) {
                customer = new Customer();
                customer.setId(UUIDUtil.uuid());
                customer.setOwner(tran.getOwner());
                customer.setName(tran.getCustomerId());
                tran.setContactId(customer.getId());
                customer.setCreateTime(DateTimeUtil.getSysTime());
                customer.setCreateBy(user.getName());
                customerMapper.insertSelective(customer);
            }
            if (activity == null) {
                activity.setId(UUIDUtil.uuid());
                activity.setOwner(tran.getOwner());
                activity.setName(tran.getActivityId());
                tran.setActivityId(activity.getId());
                activity.setCreateTime(DateTimeUtil.getSysTime());
                activity.setCreateBy(user.getName());
                activityMapper.insertSelective(activity);
            }
            if (contact == null) {
                contact.setId(UUIDUtil.uuid());
                contact.setCustomerId(customer.getId());
                contact.setOwner(tran.getOwner());
                contact.setFullname(tran.getContactId());
                tran.setContactId(contact.getId());
                contact.setCreateTime(DateTimeUtil.getSysTime());
                contact.setCreateBy(user.getName());
                contactMapper.insertSelective(contact);
            }
            tran.setId(UUIDUtil.uuid());
            tran.setCustomerId(customer.getId());
            tran.setCreateTime(DateTimeUtil.getSysTime());
            tran.setCreateBy(user.getName());
            int count = tranMapper.insertSelective(tran);
            if (count == 0) {
                throw new CrmException(CrmEnum.TRAN_SAVE);
            }
            resultVo.setMessage("修改交易成功");
        }
        resultVo.setOk(true);
        return resultVo;
    }

    @Override
    public Tran queryById(String id) {
        Tran tran = tranMapper.selectByPrimaryKey(id);

        //查询客户名称
        String customer = tran.getCustomerId();
        Customer customer1 = customerMapper.selectByPrimaryKey(customer);
        String name = customer1.getName();
        tran.setCustomerId(name);

        //查询市场活动名称
        String activity = tran.getActivityId();
        Activity activity1 = activityMapper.selectByPrimaryKey(activity);
        String name1 = activity1.getName();
        tran.setActivityId(name1);

        //查询联系人名称
        String contact = tran.getContactId();
        Contact contact1 = contactMapper.selectByPrimaryKey(contact);
        String name2 = contact1.getFullname();
        tran.setContactId(name2);

        return tran;
    }

    @Override
    public void deleteBatch(String ids) {
        //把字符串分隔成成字符串数组
        String[] aids = ids.split(",");
        //使用Arrays[专门操作数组常用类]类
        List<String> idsList = Arrays.asList(aids);
        Example example = new Example(Tran.class);
        //delete from 表 where id in(1,2,3)
        example.createCriteria().andIn("id", idsList);
        tranMapper.deleteByExample(example);
    }

    @Override
    public Tran toDetail(String id) {
        //查询交易信息
        Tran tran = tranMapper.selectByPrimaryKey(id);
        //处理所有者数据
        User user = userMapper.selectByPrimaryKey(tran.getOwner());
        tran.setOwner(user.getName());
        //处理客户数据
        Customer customer = customerMapper.selectByPrimaryKey(tran.getCustomerId());
        tran.setCustomerId(customer.getName());
        //处理市场活动数据
        Activity activity = activityMapper.selectByPrimaryKey(tran.getActivityId());
        tran.setActivityId(activity.getName());
        //处理联系人数据
        Contact contact = contactMapper.selectByPrimaryKey(tran.getContactId());
        tran.setContactId(contact.getFullname());
        //查询交易的备注
        TranRemark tranRemark = new TranRemark();
        tranRemark.setTranId(id);
        List<TranRemark> tranRemarks = tranRemarkMapper.select(tranRemark);
        for (TranRemark remark : tranRemarks) {
            remark.setTranId(tran.getName());
        }
        tran.setTranRemarks(tranRemarks);
        return tran;
    }

    @Override
    public ResultVo saveRemark(TranRemark tranRemark, User user) {
        ResultVo resultVo = new ResultVo();
        //设置主键
        tranRemark.setId(UUIDUtil.uuid());
        //创建时间和创建者
        tranRemark.setCreateTime(DateTimeUtil.getSysTime());
        tranRemark.setCreateBy(user.getName());
        //所有者和头像
        tranRemark.setOwner(user.getId());
        tranRemark.setImg(user.getImg());

        tranRemarkMapper.insertSelective(tranRemark);

        resultVo.setT(tranRemark);
        resultVo.setOk(true);
        resultVo.setMessage("添加备注成功");

        //查询备注对应的交易
        Tran tran = tranMapper.selectByPrimaryKey(tranRemark.getTranId());
        tranRemark.setTranId(tran.getName());

        return resultVo;
    }

    @Override
    public void deleteRemark(String id) {
        tranRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRemark(TranRemark tranRemark, User user) {
        //设置修改时间和修改者
        tranRemark.setEditTime(DateTimeUtil.getSysTime());
        tranRemark.setEditBy(user.getName());
        tranRemark.setEditFlag("1");
        tranRemarkMapper.updateByPrimaryKeySelective(tranRemark);
    }

    @Override
    public List<String> queryCustomerName(String customerName) {
        Example example = new Example(Customer.class);
        example.createCriteria().andLike("name", "%" + customerName + "%");
        List<Customer> customers = customerMapper.selectByExample(example);

        //定义一个集合，存储客户名称
        List<String> names = new ArrayList<>();
        for (Customer customer : customers) {
            names.add(customer.getName());
        }
        return names;
    }

    @Override
    public Tran queryStages(String id, Integer location, Map<String, String> stagePossibilityMap, User user) {
        Map<String, Object> map = new HashMap<>();
        //查询出当前交易所处的阶段
        Tran tran = tranMapper.selectByPrimaryKey(id);
        //获取交易所处的阶段
        String currentStage = null;
        //获取可能性
        String currentPossibility = null;
        //Map转ArrayList
        List<Map.Entry<String, String>> stages = new ArrayList(stagePossibilityMap.entrySet());
        if (location == null) {
            //第一次查询
            currentStage = tran.getStage();
            currentPossibility = tran.getPossibility();
        } else {
            //点击更换交易图标
            currentStage = stages.get(location).getKey();
            currentPossibility = stages.get(location).getValue();
            tran.setStage(currentStage);
            tran.setPossibility(currentPossibility);
            //修改表中交易的阶段和可能性
            tranMapper.updateByPrimaryKeySelective(tran);

            //添加交易历史对象
            TranHistory tranHistory = new TranHistory();
            tranHistory.setId(UUIDUtil.uuid());
            tranHistory.setStage(tran.getStage());
            tranHistory.setMoney(tran.getMoney());
            tranHistory.setExpectedTime(tran.getExpectedTime());
            tranHistory.setCreateTime(DateTimeUtil.getSysTime());
            tranHistory.setCreateBy(user.getName());
            tranHistory.setTranId(tran.getId());
            tranHistory.setPossibility(tran.getPossibility());

            tranHistoryMapper.insertSelective(tranHistory);
        }
        //定义position:存储当前交易所处的阶段图标在所有阶段图标中的索引
        int position = 0;
        //定义index:所有阶段中第一个交易失败的索引位置
        int index = 0;
        for (int i = 0; i < stages.size(); i++) {
            String stage = stages.get(i).getKey();
            String possibility = stages.get(i).getValue();
            if (stage.equals(currentStage)) {
                position = i;
            }

            if ("0".equals(possibility)) {
                index = i;
                break;
            }
        }

        //定义一个集合，用于存储图标对象集合
        List<StageVo> stageVos = new ArrayList<>();
        //交易失败了
        if ("0".equals(currentPossibility)) {
            //交易失败了，确定两个x，哪个是红x，哪个是黑x不能确定,还能确定7个黑圈
            for (int i = 0; i < stages.size(); i++) {
                StageVo stageVo = new StageVo();
                String stage = stages.get(i).getKey();
                String possibility = stages.get(i).getValue();
                if ("0".equals(possibility)) {
                    if (currentStage.equals(stage)) {
                        stageVo.setType("红x");
                    } else {
                        stageVo.setType("黑x");
                    }
                } else {
                    stageVo.setType("黑圈");
                }
                stageVo.setContent(stage);
                stageVo.setPossibility(possibility);
                stageVos.add(stageVo);
            }
        } else {
            //交易中 右边2个黑x
            for (int i = 0; i < stages.size(); i++) {
                StageVo stageVo = new StageVo();
                String stage = stages.get(i).getKey();
                String possibility = stages.get(i).getValue();
                if (i < position) {
                    stageVo.setType("绿圈");
                } else if (i == position) {
                    stageVo.setType("锚点");
                } else if (i > position && i < index) {
                    stageVo.setType("黑圈");
                } else {
                    stageVo.setType("黑x");
                }
                stageVo.setContent(stage);
                stageVo.setPossibility(possibility);
                stageVos.add(stageVo);
            }
        }
        tran.setStageVos(stageVos);
        Example example = new Example(TranHistory.class);
        example.createCriteria().andEqualTo("tranId", tran.getId());
        example.setOrderByClause("createTime");
        List<TranHistory> tranHistories = tranHistoryMapper.selectByExample(example);
        tran.setTranHistories(tranHistories);
        return tran;
    }

    @Override
    public void clearHistory(String id) {
        Example example = new Example(TranHistory.class);
        //delete from 表 where id in(1,2,3)
        example.createCriteria().andEqualTo("tranId", id);
        tranHistoryMapper.deleteByExample(example);
    }

}
