package com.bjpowernode.workbench.service.impl;

import cn.hutool.core.util.StrUtil;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.CommonUtil;
import com.bjpowernode.base.util.DateTimeUtil;
import com.bjpowernode.base.util.UUIDUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import com.bjpowernode.workbench.bean.*;
import com.bjpowernode.workbench.mapper.*;
import com.bjpowernode.workbench.service.ClueService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cty
 * @date 2021/11/4 16:07
 */
@Service
public class ClueServiceImpl implements ClueService {

    @Autowired
    private ClueMapper clueMapper;

    @Autowired
    private ClueRemarkMapper clueRemarkMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityClueRelationMapper activityClueRelationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ContactMapper contactMapper;

    @Autowired
    private CustomerRemarkMapper customerRemarkMapper;

    @Autowired
    private ContactRemarkMapper contactRemarkMapper;

    @Autowired
    private ActivityContactRelationMapper activityContactRelationMapper;

    @Autowired
    private TranMapper tranMapper;

    @Autowired
    private TranHistoryMapper tranHistoryMapper;

    @Autowired
    private TranRemarkMapper tranRemarkMapper;

    @Override
    public List<Clue> list(int page, int pageSize, Clue clue) {
        Example example = new Example(Clue.class);
        Example.Criteria criteria = example.createCriteria();
        //线索模糊查询 !null str.length!=0
        if (StrUtil.isNotEmpty(clue.getFullname())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("fullname", "%" + clue.getFullname() + "%");
        }

        //公司模糊查询
        if (StrUtil.isNotEmpty(clue.getCompany())) {
            //根据公司的名字模糊查询出满足条件的公司
            Example example1 = new Example(Customer.class);
            example1.createCriteria().andLike("name", "%" + clue.getCompany() + "%");
            List<Customer> customers = customerMapper.selectByExample(example1);

            //定义一个集合，存储客户的主键
            List<String> ids = new ArrayList<>();
            for (Customer customer : customers) {
                ids.add(customer.getId());
            }

            //根据查询出来的客户的外键查询公司
            criteria.andIn("company", ids);
        }

        //公司座机模糊查询
        if (StrUtil.isNotEmpty(clue.getPhone())) {
            criteria.andLike("phone", "%" + clue.getPhone() + "%");
        }

        //手机模糊查询
        if (StrUtil.isNotEmpty(clue.getMphone())) {
            criteria.andLike("mphone", "%" + clue.getMphone() + "%");
        }

        //线索来源模糊查询
        if (!"---请选择---".equals(clue.getSource())) {
            criteria.andEqualTo("source", clue.getSource());
        }

        //所有者模糊查询
        if (StrUtil.isNotEmpty(clue.getOwner())) {
            //根据用户的名字模糊查询出满足条件的用户
            Example example2 = new Example(User.class);
            example2.createCriteria().andLike("name", "%" + clue.getOwner() + "%");
            List<User> users = userMapper.selectByExample(example2);

            //定义一个集合，存储用户的主键
            List<String> ids = new ArrayList<>();
            for (User user : users) {
                ids.add(user.getId());
            }

            //根据查询出来的用户的外键查询所有者
            criteria.andIn("owner", ids);
        }

        //线索状态模糊查询
        if (!"---请选择---".equals(clue.getState())) {
            criteria.andEqualTo("state", clue.getState());
        }

        //该行代码等同于 limit a,b 参数1:当前页码 参数2:每页记录数 a=(page-1)*pageSize,b
        PageHelper.startPage(page, pageSize);
        //按发布时间降序排序
        example.setOrderByClause("createTime desc");

        List<Clue> clues = clueMapper.selectByExample(example);
        for (Clue clue1 : clues) {
            String company = clue1.getCompany();
            Customer customer = customerMapper.selectByPrimaryKey(company);
            clue1.setCompany(customer.getName());

            String owner = clue1.getOwner();
            User user = userMapper.selectByPrimaryKey(owner);
            clue1.setOwner(user.getName());
        }
        return clues;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.selectAll();
    }

    @Override
    public ResultVo saveOrUpdate(Clue clue, User user) {
        ResultVo resultVo = new ResultVo();
        //获取线索的主键
        String id = clue.getId();
        String company = clue.getCompany();
        Example example = new Example(Customer.class);
        example.createCriteria().andEqualTo("name", company);
        Customer customer1 = customerMapper.selectOneByExample(example);
        if (id == null) {
            //添加
            //主键
            if (customer1 == null) {
                Customer customer = new Customer();
                customer.setId(UUIDUtil.uuid());
                customer.setOwner(clue.getOwner());
                customer.setName(clue.getCompany());
                clue.setCompany(customer.getId());
                customerMapper.insertSelective(customer);
            }
            clue.setId(UUIDUtil.uuid());
            clue.setCreateTime(DateTimeUtil.getSysTime());
            clue.setCreateBy(user.getName());
            int count = clueMapper.insertSelective(clue);
            if (count == 0) {
                throw new CrmException(CrmEnum.CLUE_SAVE);
            }
            resultVo.setMessage("添加线索成功");
        } else {
            //修改
            if (customer1 == null) {
                Customer customer = new Customer();
                customer.setId(UUIDUtil.uuid());
                customer.setOwner(clue.getOwner());
                customer.setName(clue.getCompany());
                clue.setCompany(customer.getId());
                customerMapper.insertSelective(customer);
            }
            clue.setEditTime(DateTimeUtil.getSysTime());
            clue.setEditBy(user.getName());
            int count = clueMapper.updateByPrimaryKeySelective(clue);
            if (count == 0) {
                throw new CrmException(CrmEnum.CLUE_UPDATE);
            }
            resultVo.setMessage("修改线索成功");
        }
        resultVo.setOk(true);
        return resultVo;
    }

    @Override
    public Clue queryById(String id) {

        //查询线索数据
        Clue clue = clueMapper.selectByPrimaryKey(id);

        //根据客户查询公司名称
        String company = clue.getCompany();
        Customer customer = customerMapper.selectByPrimaryKey(company);
        String name = customer.getName();
        clue.setCompany(name);

        //再查询备注数据

        //查询关联的市场活动数据
        ActivityClueRelation activityClueRelation = new ActivityClueRelation();
        activityClueRelation.setClueId(id);
        List<ActivityClueRelation> activityClueRelations = activityClueRelationMapper.select(activityClueRelation);

        //定义一个集合，存储关系表中的所有市场活动的主键
        List<String> ids = new ArrayList<>();
        for (ActivityClueRelation activityClueRelation1 : activityClueRelations) {
            ids.add(activityClueRelation1.getActivityId());
        }

        List<Activity> activities = null;
        if (ids.size() != 0) {
            //查询关联的市场活动 使用 in
            Example example = new Example(Activity.class);
            example.createCriteria().andIn("id", ids);
            activities = activityMapper.selectByExample(example);
        }

        CommonUtil.convertOwner(activities, Activity.class, userMapper);

        //把线索关联的市场设置一下
        clue.setActivities(activities);

        return clue;
    }

    @Override
    public void deleteBatch(String ids) {
        //把字符串分隔成成字符串数组
        String[] aids = ids.split(",");
        //使用Arrays[专门操作数组常用类]类
        List<String> idsList = Arrays.asList(aids);
        Example example = new Example(Clue.class);
        //delete from 表 where id in(1,2,3)
        example.createCriteria().andIn("id", idsList);
        clueMapper.deleteByExample(example);
    }

    @Override
    public Clue toDetail(String id) {
        //查询线索自身的信息
        Clue clue = clueMapper.selectByPrimaryKey(id);

        //处理客户数据
        Customer customer = customerMapper.selectByPrimaryKey(clue.getCompany());
        clue.setCompany(customer.getName());
        //处理所有者数据
        User user = userMapper.selectByPrimaryKey(clue.getOwner());
        clue.setOwner(user.getName());

        //查询线索的备注数据
        ClueRemark clueRemark = new ClueRemark();
        clueRemark.setClueId(id);
        List<ClueRemark> clueRemarks = clueRemarkMapper.select(clueRemark);
        for (ClueRemark remark : clueRemarks) {
            remark.setClueId(clue.getFullname());
        }

        clue.setClueRemarks(clueRemarks);
        return clue;
    }

    @Override
    public ResultVo saveRemark(ClueRemark clueRemark, User user) {
        ResultVo resultVo = new ResultVo();
        //设置主键
        clueRemark.setId(UUIDUtil.uuid());
        //创建时间和创建者
        clueRemark.setCreateTime(DateTimeUtil.getSysTime());
        clueRemark.setCreateBy(user.getName());

        //所有者和头像
        clueRemark.setOwner(user.getId());
        clueRemark.setImg(user.getImg());

        clueRemarkMapper.insertSelective(clueRemark);

        resultVo.setT(clueRemark);
        resultVo.setOk(true);
        resultVo.setMessage("添加备注成功");

        //查询备注对应的线索
        Clue clue = clueMapper.selectByPrimaryKey(clueRemark.getClueId());
        clueRemark.setClueId(clue.getCompany());
        return resultVo;
    }

    @Override
    public void deleteRemark(String id) {
        clueRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRemark(ClueRemark clueRemark, User user) {
        //设置修改时间和修改者
        clueRemark.setEditBy(user.getName());
        clueRemark.setEditTime(DateTimeUtil.getSysTime());
        clueRemark.setEditFlag("1");

        clueRemarkMapper.updateByPrimaryKeySelective(clueRemark);
    }

    @Override
    public List<Activity> searchActivity(String name, String id) {
        //查询线索已经关联的市场活动
        ActivityClueRelation activityClueRelation = new ActivityClueRelation();
        activityClueRelation.setClueId(id);
        List<ActivityClueRelation> activityClueRelations = activityClueRelationMapper.select(activityClueRelation);

        //定义一个集合，存储中间表中的所有市场活动的主键
        List<String> ids = new ArrayList<>();
        for (ActivityClueRelation clueActivityRelation1 : activityClueRelations) {
            ids.add(clueActivityRelation1.getActivityId());
        }

        Example example = new Example(Activity.class);
        Example.Criteria criteria = example.createCriteria();

        if (ids.size() == 0) {
            if (StrUtil.isNotEmpty(name)) {
                criteria.andLike("name", "%" + name + "%");
            }
        } else {
            if (StrUtil.isNotEmpty(name)) {
                criteria.andLike("name", "%" + name + "%").andNotIn("id", ids);
            } else {
                criteria.andNotIn("id", ids);
            }
        }

        List<Activity> activities = activityMapper.selectByExample(example);
        CommonUtil.convertOwner(activities, Activity.class, userMapper);
        return activities;
    }

    @Override
    public ResultVo bind(String id, String ids, User user) {
        ResultVo resultVo = new ResultVo();
        String[] aids = ids.split(",");
        List<Activity> activities = new ArrayList<>();
        for (String aid : aids) {
            ActivityClueRelation activityClueRelation = new ActivityClueRelation();
            activityClueRelation.setId(UUIDUtil.uuid());
            activityClueRelation.setClueId(id);
            activityClueRelation.setActivityId(aid);
            activityClueRelationMapper.insertSelective(activityClueRelation);

            //查询市场活动
            Activity activity = activityMapper.selectByPrimaryKey(aid);
            activity.setOwner(user.getName());
            activities.add(activity);
        }
        resultVo.setOk(true);
        resultVo.setMessage("关联成功");
        resultVo.setT(activities);
        return resultVo;
    }

    @Override
    public void unbind(ActivityClueRelation activityClueRelation) {
        activityClueRelationMapper.delete(activityClueRelation);
    }

    @Override
    public Clue toConvert(String id) {
        return clueMapper.selectByPrimaryKey(id);
    }

    @Override
    public void convert(String id, String isCreateTransaction, Tran tan, User user) {
        int count = 0;
        //1、根据线索的主键查询线索的信息(线索包含自身的信息，包含客户的信息，包含联系人信息)
        Clue clue = clueMapper.selectByPrimaryKey(id);

        //2、先将线索中的客户信息取出来保存在客户表中，当该客户不存在的时候，新建客户(按公司名称精准查询)
        String company = clue.getCompany();

        Customer customer = new Customer();


        customer.setName(company);
        List<Customer> customers = customerMapper.select(customer);
        if (customers.size() == 0) {
            //客户不存在，创建新客户,如果信息不全，可以通过指定模块中修改功能完善信息
            customer.setId(UUIDUtil.uuid());
            customer.setOwner(clue.getOwner());
            customer.setWebsite(clue.getWebsite());
            customer.setPhone(clue.getPhone());
            customer.setCreateBy(user.getName());
            customer.setCreateTime(DateTimeUtil.getSysTime());
            customer.setContactSummary(clue.getContactSummary());
            customer.setNextContactTime(clue.getNextContactTime());
            customer.setDescription(clue.getDescription());
            count = customerMapper.insertSelective(customer);
            if (count == 0) {
                //转换失败
            }
        } else {
            customer = customers.get(0);
        }

        //3、将线索中联系人信息取出来保存在联系人表中 (备份联系人数据)
        Contact contact = new Contact();
        contact.setId(UUIDUtil.uuid());
        contact.setOwner(clue.getOwner());
        contact.setSource(clue.getSource());
        contact.setCustomerId(customer.getId());
        contact.setFullname(clue.getFullname());
        contact.setAppellation(clue.getAppellation());
        contact.setEmail(clue.getEmail());
        contact.setMphone(clue.getMphone());
        contact.setJob(clue.getJob());

        contact.setCreateBy(user.getName());
        contact.setCreateTime(DateTimeUtil.getSysTime());
        contact.setAddress(clue.getAddress());

        count = contactMapper.insertSelective(contact);
        if (count == 0) {
            //转换失败
        }

        //4、线索中的备注信息取出来保存在客户备注和联系人备注中 (备份客户和联系人备注表信息)
        //备份客户备注
        CustomerRemark customerRemark = new CustomerRemark();
        customerRemark.setId(UUIDUtil.uuid());
        customerRemark.setCreateBy(user.getName());
        customerRemark.setCreateTime(DateTimeUtil.getSysTime());
        customerRemark.setCustomerId(customer.getId());

        customerRemarkMapper.insertSelective(customerRemark);

        //备份联系人备注
        ContactRemark contactRemark = new ContactRemark();
        contactRemark.setId(UUIDUtil.uuid());
        contactRemark.setCreateBy(user.getName());
        contactRemark.setCreateTime(DateTimeUtil.getSysTime());
        contactRemark.setContactId(contact.getId());

        contactRemarkMapper.insertSelective(contactRemark);

        //5、将"线索和市场活动的关系"转换到"联系人和市场活动的关系中"
        //先查询出线索已经关联的市场活动
        ActivityClueRelation activityClueRelation = new ActivityClueRelation();
        activityClueRelation.setClueId(id);
        List<ActivityClueRelation> activityContactRelations = activityClueRelationMapper.select(activityClueRelation);
        for (ActivityClueRelation activityContactRelation1 : activityContactRelations) {
            ActivityContactRelation activityContactRelation = new ActivityContactRelation();
            activityContactRelation.setId(UUIDUtil.uuid());
            activityContactRelation.setContactId(contact.getId());
            activityContactRelation.setActivityId(activityContactRelation1.getActivityId());

            activityContactRelationMapper.insertSelective(activityContactRelation);
        }

        //6、如果转换过程中发生了交易，创建一条新的交易，交易信息不全，后面可以通过修改交易来完善交易信息
        if ("1".equals(isCreateTransaction)) {
            //发生交易了
            Tran tran = new Tran();
            tran.setId(UUIDUtil.uuid());
            tran.setOwner(clue.getOwner());
            tran.setCustomerId(customer.getId());
            tran.setSource(clue.getSource());
            tran.setContactId(contact.getId());
            tran.setCreateBy(user.getName());
            tran.setCreateTime(DateTimeUtil.getSysTime());
            tran.setDescription(clue.getDescription());
            tran.setContactSummary(clue.getContactSummary());
            tran.setNextContactTime(clue.getNextContactTime());

            tranMapper.insertSelective(tran);

            //7、创建该条交易对应的交易历史以及备注

            //添加交易历史
            TranHistory tranHistory = new TranHistory();
            tranHistory.setId(UUIDUtil.uuid());
            tranHistory.setStage(tran.getStage());
            tranHistory.setMoney(tran.getMoney());
            tranHistory.setExpectedTime(tran.getExpectedTime());
            tranHistory.setCreateTime(DateTimeUtil.getSysTime());
            tranHistory.setCreateBy(user.getName());
            tranHistory.setTranId(tran.getId());
            tranHistoryMapper.insertSelective(tranHistory);

            //添加交易备注
            TranRemark tranRemark = new TranRemark();
            tranRemark.setId(UUIDUtil.uuid());
            tranRemark.setCreateBy(user.getName());
            tranRemark.setCreateTime(DateTimeUtil.getSysTime());
            tranRemark.setTranId(tran.getId());

            tranRemarkMapper.insertSelective(tranRemark);

        }
    }

    @Override
    public List<Activity> queryRelationActivities(String id, String name) {
        //查询线索中已经关联的市场活动，还要支持模糊查询
        ActivityClueRelation activityClueRelation = new ActivityClueRelation();
        activityClueRelation.setClueId(id);
        List<ActivityClueRelation> activityClueRelations = activityClueRelationMapper.select(activityClueRelation);

        //把关联市场活动的主键放入到集合中
        List<String> ids = new ArrayList<>();
        for (ActivityClueRelation activityClueRelation1 : activityClueRelations) {
            ids.add(activityClueRelation1.getActivityId());
        }

        //模糊查询市场活动
        Example example = new Example(Activity.class);
        example.createCriteria().andLike("name", "%" + name + "%").andIn("id", ids);
        List<Activity> activities = activityMapper.selectByExample(example);
        CommonUtil.convertOwner(activities, Activity.class, userMapper);
        return activities;
    }
}
