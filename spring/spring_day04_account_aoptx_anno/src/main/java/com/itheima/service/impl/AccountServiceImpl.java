package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer acccountId) {
        accountDao.deleteAccount(acccountId);
    }

    public void transfer(String sourceName, String targetName, Float money) {

        System.out.println("transfer...");
        Account source = accountDao.findAccountByName(sourceName);

        Account target = accountDao.findAccountByName(targetName);


        target.setMoney(target.getMoney() + money);
        System.out.println(target.getMoney());
        source.setMoney(source.getMoney() - money);
        System.out.println(source.getMoney());

        accountDao.updateAccount(target);
        accountDao.updateAccount(source);


    }
}
