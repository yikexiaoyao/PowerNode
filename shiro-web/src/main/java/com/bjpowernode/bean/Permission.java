package com.bjpowernode.bean;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

@Data
public class Permission {

    private String pid;
    private String pname;
    private String url;
    private String parent_id;
    private String code;

    private List<Permission> sons;//菜单下的子菜单

}
