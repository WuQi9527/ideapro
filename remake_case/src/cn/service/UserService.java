package cn.service;

import cn.domain.PageBean;
import cn.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User login(User user);

    User findUserById(String id);

    List<User> findAll();

    void addUser(User user);

    void delUser(String id);

    void updateUser(User user);

    void delSelectUser(String[] uids);

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
