package com.bjpowernode.bean;

import lombok.Data;

import javax.persistence.Id;

@Data
public class User {

    private String uid;
    private String username;
    private String password;
    private String salt;

}
