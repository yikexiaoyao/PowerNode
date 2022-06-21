package com.bjpowernode.base.cache;

import com.bjpowernode.base.bean.DicType;
import com.bjpowernode.base.bean.DicValue;
import com.bjpowernode.base.mapper.DicTypeMapper;
import com.bjpowernode.base.mapper.DicValueMapper;
import com.bjpowernode.setting.bean.User;
import com.bjpowernode.setting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.*;

/**
 * @author cty
 * @date 2021/11/5 16:05
 */
@Component
public class CrmCache {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DicTypeMapper dicTypeMapper;

    @Autowired
    private DicValueMapper dicValueMapper;

    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void init(){

        //缓存所有者
        List<User> users = userMapper.selectAll();

        servletContext.setAttribute("users", users);

        //Map<String,List<DicValue>>
        Map<String, List<DicValue>> map = new HashMap<>();
        //先查询字典类型
        List<DicType> dicTypes = dicTypeMapper.selectAll();
        for (DicType dicType : dicTypes) {
            //获取字典类型的主键
            String code = dicType.getCode();
            Example example = new Example(DicValue.class);
            example.setOrderByClause("orderNo asc");
            example.createCriteria().andEqualTo("typeCode", code);
            List<DicValue> dicValues = dicValueMapper.selectByExample(example);
            map.put(code, dicValues);
        }

        servletContext.setAttribute("map", map);

        ResourceBundle resourceBundle = ResourceBundle.getBundle("mybatis.StagePossibility");

        //定义Map<String,String>存储阶段和可能性
        Map<String,String> stagePossibilityMap = new TreeMap<>();
        Enumeration<String> keys = resourceBundle.getKeys();
        for(;keys.hasMoreElements();){
            String key = keys.nextElement();
            String value = resourceBundle.getString(key);

            stagePossibilityMap.put(key, value);
        }
        servletContext.setAttribute("stagePossibilityMap", stagePossibilityMap);
    }
}
