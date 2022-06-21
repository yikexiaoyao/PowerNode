package com.bjpowernode.controller;

import com.bjpowernode.bean.ResultVo;
import com.bjpowernode.bean.Role;
import com.bjpowernode.bean.TreeNode;
import com.bjpowernode.exception.CrmException;
import com.bjpowernode.mapper.RoleMapper;
import com.bjpowernode.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping("/settings/role/list")
    @ResponseBody
    public List<Role> list() {
        List<Role> roles = roleService.list();
        return roles;
    }

    @RequestMapping("/settings/role/toAdd")
    @RequiresPermissions("role:add")
    public String toAdd() {
        return "/settings/role/add";
    }

    @RequestMapping("/settings/role/addRole")
    @ResponseBody
    public ResultVo addRole(@Param("roleId") String roleId, @Param("roleName") String roleName) {
        ResultVo<Object> resultVo = new ResultVo<>();
        try {
            roleMapper.insertRole(roleId, roleName);
        } catch (Exception e) {
            e.printStackTrace();
            resultVo.setMessage("插入失败");
            resultVo.setOk(false);
            return resultVo;
        }
        resultVo.setMessage("插入成功");
        resultVo.setOk(true);
        return  resultVo;
    }

    //查询所有权限树
    @RequestMapping("/settings/role/queryPermissionTrees")
    @ResponseBody
    public List<TreeNode> queryPermissionTrees(String id) {
        return roleService.queryPermissionTrees(id);
    }

    //授权
    @RequestMapping("/settings/role/authorize")
    @ResponseBody
    public String authorize(String id, String ids) {
        roleService.authorize(id, ids);
        return "授权成功";
    }

    //删除角色权限
    @RequestMapping("/settings/role/toDelete")
    @RequiresPermissions("role:delete")
    @ResponseBody
    public ResultVo toDelete(String ids) {
        ResultVo resultVo = new ResultVo();
        try {
            roleService.toDelete(ids);
            resultVo.setOk(true);
            resultVo.setMessage("删除角色成功");
        } catch (CrmException e) {
            resultVo.setMessage(e.getMessage());
        }
        return resultVo;
    }
}
