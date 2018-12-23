package cn.service;

import cn.domain.PageBean;
import cn.domain.User;

import java.util.List;

public interface UserService {
    User login(User user);

    List<User> findAll();

    void add(User user);


    void delUser(int id);

    User findUser(int id);


    void updateUser(User user);

    void delSelectUser(String[] uids);

    PageBean<User> findUserByPage(String currentPage, String rows);
}
