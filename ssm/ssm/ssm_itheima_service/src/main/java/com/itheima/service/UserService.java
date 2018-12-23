package com.itheima.service;



import com.itheima.domain.Pages;
import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    User findUser(User user) throws Exception;
    List<User> findAll(Pages pages)throws  Exception;
    void saveUser(User user)throws Exception;


    Integer findCounts(Pages pages) throws Exception;
}
