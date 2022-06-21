package com.bjpowernode.workbench.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import com.bjpowernode.base.bean.ResultVo;
import com.bjpowernode.base.exception.CrmEnum;
import com.bjpowernode.base.exception.CrmException;
import com.bjpowernode.base.util.DateTimeUtil;
import com.bjpowernode.base.util.UUIDUtil;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import com.bjpowernode.workbench.bean.Activity;
import com.bjpowernode.workbench.bean.ActivityRemark;
import com.bjpowernode.workbench.bean.Customer;
import com.bjpowernode.workbench.mapper.ActivityMapper;
import com.bjpowernode.workbench.mapper.ActivityRemarkMapper;
import com.bjpowernode.workbench.service.ActivityService;
import com.github.pagehelper.PageHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author cty
 * @date 2021/10/28 16:07
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityRemarkMapper activityRemarkMapper;

    @Override
    public List<Activity> list(int pageNum, int pageSize, Activity activity) {

        Example example = new Example(Activity.class);
        Example.Criteria criteria = example.createCriteria();

        //市场活动模糊查询
        if (StrUtil.isNotEmpty(activity.getName())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLike("name", "%" + activity.getName() + "%");
        }

        //所有者模糊查询
        if (StrUtil.isNotEmpty(activity.getOwner())) {
            //根据用户的名字模糊查询出满足条件的用户
            Example example1 = new Example(User.class);
            example1.createCriteria().andLike("name", "%" + activity.getOwner() + "%");
            List<User> users = userMapper.selectByExample(example1);

            //定义一个集合，存储用户的主键
            List<String> ids = new ArrayList<>();
            for (User user : users) {
                ids.add(user.getId());
            }

            //根据查询出来的用户的外键查询市场活动
            criteria.andIn("owner", ids);
        }

        //开始日期  仅获取该日期
        if (StrUtil.isNotEmpty(activity.getStartTime())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andGreaterThanOrEqualTo("startTime", activity.getStartTime());
        }

        //结束日期  获取截止到该日期的所有时间
        if (StrUtil.isNotEmpty(activity.getEndTime())) {
            //参数1:实体类属性名 参数2:实际的参数
            criteria.andLessThanOrEqualTo("endTime", activity.getEndTime());
        }

        //该行代码等同于 limit a,b 参数1:当前页码 参数2:每页记录数 a=(page-1)*pageSize,b
        PageHelper.startPage(pageNum, pageSize);
        //按发布时间降序排序
        example.setOrderByClause("createTime desc");

        List<Activity> activities = activityMapper.selectByExample(example);
        for (Activity activity1 : activities) {
            String owner = activity1.getOwner();
            User user = userMapper.selectByPrimaryKey(owner);
            activity1.setOwner(user.getName());
        }

        return activities;
    }

    @Override
    public List<User> queryUsers() {
        return userMapper.selectAll();
    }

    @Override
    public ResultVo saveOrUpdate(Activity activity, User user) {
        ResultVo resultVo = new ResultVo();
        //获取市场活动的主键
        String id = activity.getId();
        if (id == null) {
            //添加
            //主键
            activity.setId(UUIDUtil.uuid());
            activity.setCreateTime(DateTimeUtil.getSysTime());
            activity.setCreateBy(user.getName());
            int count = activityMapper.insertSelective(activity);
            if (count == 0) {
                throw new CrmException(CrmEnum.ACTIVITY_SAVE);
            }
            resultVo.setMessage("添加市场活动成功");
        } else {
            //修改
            activity.setEditBy(user.getName());
            activity.setEditTime(DateTimeUtil.getSysTime());
            int count = activityMapper.updateByPrimaryKeySelective(activity);
            if (count == 0) {
                throw new CrmException(CrmEnum.ACTIVITY_UPDATE);
            }
            resultVo.setMessage("修改市场活动成功");
        }
        resultVo.setOk(true);
        return resultVo;
    }

    @Override
    public Activity queryById(String id) {
        Activity activity = activityMapper.selectByPrimaryKey(id);
        String user = activity.getOwner();
        User user1 = userMapper.selectByPrimaryKey(user);
        String name = user1.getName();
        activity.setOwner(name);
        return activity;
    }

    @Override
    public void deleteBatch(String ids) {
        //把字符串分隔成成字符串数组
        String[] aids = ids.split(",");
        //使用Arrays[专门操作数组常用类]类
        List<String> idsList = Arrays.asList(aids);
        Example example = new Example(Activity.class);
        //delete from 表 where id in(1,2,3)
        example.createCriteria().andIn("id", idsList);
        activityMapper.deleteByExample(example);
    }

    @Override
    public Activity toDetail(String id) {
        //查询市场活动信息
        Activity activity = activityMapper.selectByPrimaryKey(id);
        //处理所有者数据
        User user = userMapper.selectByPrimaryKey(activity.getOwner());
        activity.setOwner(user.getName());
        //查询市场活动的备注
        ActivityRemark activityRemark = new ActivityRemark();
        activityRemark.setActivityId(id);
        List<ActivityRemark> activityRemarks = activityRemarkMapper.select(activityRemark);
        for (ActivityRemark remark : activityRemarks) {
            remark.setActivityId(activity.getName());
        }
        activity.setActivityRemarks(activityRemarks);
        return activity;
    }

    @Override
    public ResultVo saveRemark(ActivityRemark activityRemark, User user) {
        ResultVo resultVo = new ResultVo();
        //设置主键
        activityRemark.setId(UUIDUtil.uuid());
        //创建时间和创建者
        activityRemark.setCreateTime(DateTimeUtil.getSysTime());
        activityRemark.setCreateBy(user.getName());
        //所有者和头像
        activityRemark.setOwner(user.getId());
        activityRemark.setImg(user.getImg());

        activityRemarkMapper.insertSelective(activityRemark);

        resultVo.setT(activityRemark);
        resultVo.setOk(true);
        resultVo.setMessage("添加备注成功");

        //查询备注对应的市场活动
        Activity activity = activityMapper.selectByPrimaryKey(activityRemark.getActivityId());
        activityRemark.setActivityId(activity.getName());

        return resultVo;
    }

    @Override
    public void deleteRemark(String id) {
        activityRemarkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateRemark(ActivityRemark activityRemark, User user) {
        //设置修改时间和修改者
        activityRemark.setEditTime(DateTimeUtil.getSysTime());
        activityRemark.setEditBy(user.getName());
        activityRemark.setEditFlag("1");
        activityRemarkMapper.updateByPrimaryKeySelective(activityRemark);
    }

    @Override
    public ExcelWriter exportExcel() {
        ExcelWriter writer = ExcelUtil.getWriter(true);
        Example example = new Example(Activity.class);
        List<Activity> activities = activityMapper.selectByExample(example);
        //把实体类的属性都放入到map中，集合属性不会放入
        Map<String, EntityColumn> propertyMap = example.getPropertyMap();
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(propertyMap.size() - 1, "市场活动报表");
        // 定义单元格背景色
        StyleSet style = writer.getStyleSet();
        // 第二个参数表示是否也设置头部单元格背景
        style.setBackgroundColor(IndexedColors.RED, false);

        //设置内容字体
        Font font = writer.createFont();
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        font.setItalic(true);
        //第二个参数表示是否忽略头部样式
        writer.getStyleSet().setFont(font, true);
        writer.write(activities, true);
        return writer;
    }

}
