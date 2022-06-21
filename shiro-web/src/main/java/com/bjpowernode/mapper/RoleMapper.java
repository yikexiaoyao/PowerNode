package com.bjpowernode.mapper;

import com.bjpowernode.bean.Permission;
import com.bjpowernode.bean.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface RoleMapper {
    List<Role> selectAllRoles();

    List<Permission> queryAllPermissions();

    List<Permission> queryPermissionByRole(@Param("id") String id);

    void delelteAllPermission(@Param("id") String id);

    void insertPermission(@Param("roleId") String id, @Param("pId") String pId);

    void deleteByExample(@Param("roleId") String roleId);

    void insertRole(@Param("roleId") String roleId, @Param("roleName") String roleName);
}
