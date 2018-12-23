package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    void addUser(User user);


    //删除功能
    void deleteUser(String id);

    User findUserById(String id);

    void updateUser(User user);

    void delSelectUser(String[] uids);
}
