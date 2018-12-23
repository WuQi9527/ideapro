package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name="accountDao")
    private IAccountDao accountDao=null;
    @PostConstruct
    public void init(){
        System.out.println("初始方法执行了");
    }
    @PreDestroy
    public  void destroy(){
        System.out.println("销毁方法执行了");
    }
    public void saveAccount() {
        accountDao.saveAccount();
        //System.out.println("保存成功!");
    }
}
