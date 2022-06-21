package com.bjpowernode.service.impl;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.Role;
import com.bjpowernode.bean.TreeNode;
import com.bjpowernode.mapper.RoleMapper;
import com.bjpowernode.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> list() {
        List<Role> roles = roleMapper.selectAllRoles();
        return roles;
    }

    @Override
    public List<TreeNode> queryPermissionTrees(String id) {
        //所有的权限
        List<Permission> permissions = roleMapper.queryAllPermissions();

        //查询角色对应的权限
        List<Permission> rolePermissions = roleMapper.queryPermissionByRole(id);

        //定义一个集合存储权限树
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission permission : permissions) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(permission.getPid());
            if(permission.getParent_id() != null){
                treeNode.setPId(permission.getParent_id());
            }
            treeNode.setName(permission.getPname());
            if(permission.getParent_id() == null){
                treeNode.setOpen(true);
            }

            //让当前角色对应的权限复选框勾中
            for(Permission p : rolePermissions){
                if(permission.getPid().equals(p.getPid())){
                    treeNode.setChecked(true);
                }
            }
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }

    @Override
    public void authorize(String id, String ids) {
        //分隔字符串
        String[] pIds = ids.split(",");
        //先删除当前角色的所有权限
        roleMapper.delelteAllPermission(id);

        //插入新的权限
        for (String pId : pIds) {
            roleMapper.insertPermission(id,pId);
        }

    }

    @Override
    public void toDelete(String ids) {
        //把字符串分隔成成字符串数组
        String[] aids = ids.split(",");
        //使用Arrays[专门操作数组常用类]类
        List<String> idsList = Arrays.asList(aids);
        for (String s : idsList) {
            roleMapper.deleteByExample(s);
        }
    }

}
