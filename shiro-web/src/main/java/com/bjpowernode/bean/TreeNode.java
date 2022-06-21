package com.bjpowernode.bean;

import lombok.Data;

@Data
public class TreeNode {

    private String id;//树的节点 指定成权限的主键
    private String pId;//父节点
    private String name;//节点名称 权限名称:pname
    private boolean open;//节点是否展开
    private boolean checked;//节点是否勾中

}
