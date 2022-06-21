package model.service;

import entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author cty
 * @date 2021/10/21 9:10
 */
public interface IUserService {
    List<User> list();

    User get(int id);

    void save(User user);

    void update(User user);

    void delete(int id);

    User getByUserName(String userName);

    void delBatch(Object ids);

}
