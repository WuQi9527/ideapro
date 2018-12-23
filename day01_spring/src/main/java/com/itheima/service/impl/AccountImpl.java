package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountServvice;

public class AccountImpl implements AccountServvice {
    private AccountDao accountDao;
    public void AccountImpl(){
        System.out.println("对象创建了..");
    }
    public void saveAccount() {
       accountDao.saveAccount();

    }
}
