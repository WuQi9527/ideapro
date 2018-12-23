package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("保存了");
    }

    public void updateAccount(int i) {
        int j=1/0;
        System.out.println("更新了"+1);

    }

    public void deleteAccount() {
        System.out.println("删除");

    }
}
