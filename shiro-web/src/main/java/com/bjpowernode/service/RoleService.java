package com.bjpowernode.service;

import com.bjpowernode.bean.Role;
import com.bjpowernode.bean.TreeNode;

import java.util.List;

public interface RoleService {
    List<Role> list();

    List<TreeNode> queryPermissionTrees(String id);

    void authorize(String id, String ids);

    void toDelete(String ids);
}
