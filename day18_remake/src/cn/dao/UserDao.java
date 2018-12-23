package cn.dao;

import cn.domain.User;

import java.util.List;

public interface UserDao {

    User findUserByUsernameAndPassword(String username, String password);

    List<User> finAll();

    void add(User user);

    void delUser(int id);

    User findUser(int id);


    void updateUser(User user);

    int findTotalCount();

    List<User> findByPage(int start, int rows);
}
