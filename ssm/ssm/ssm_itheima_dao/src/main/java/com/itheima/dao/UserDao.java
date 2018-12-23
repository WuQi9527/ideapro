package com.itheima.dao;


import com.itheima.domain.Pages;
import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll(Pages pages)throws Exception;
    User findUser(User user) throws Exception;
    void saveUser(User user)throws Exception;
    Integer findCounts(Pages pages) throws Exception;
}
