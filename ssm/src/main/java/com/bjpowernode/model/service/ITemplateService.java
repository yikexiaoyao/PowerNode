package com.bjpowernode.model.service;

import java.util.List;

/**
 * @author cty
 * @date 2021/10/12 10:32
 */
public interface ITemplateService<T> {
    List<T> list();

    T get(int id);

    void save(T obj);

    void update(T obj);

    void delete(int id);
}
