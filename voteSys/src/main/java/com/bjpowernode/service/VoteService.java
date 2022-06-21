package com.bjpowernode.service;

import com.bjpowernode.bean.Article;
import com.bjpowernode.bean.User;

import java.util.List;

/**
 * @author cty
 * @date 2021/11/27 19:30
 */
public interface VoteService {
    void push(Article article, User user);

    List<Article> list(String type,int pageSize, int page, String ascOrDesc);

    int count();

    boolean vote(String id, User user);

    List<Article> search(String keyword);
}
