package com.itheima.service.impl;


import com.itheima.dao.UserDao;
import com.itheima.domain.Pages;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(User user) throws Exception {
        return userDao.findUser(user);
    }

    @Override
    public List<User> findAll(Pages pages) throws Exception {

            if(pages!=null && pages.getPageNum()!=null && pages.getPageCounts()!=null){
                //pages进行每页起始记录处理
                pages.setStartNum((pages.getPageNum()-1)*pages.getPageCounts());
            }

        return userDao.findAll(pages);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userDao.saveUser(user);
    }

    @Override
    public Integer findCounts(Pages pages) throws Exception {
        return userDao.findCounts(pages);
    }
}
