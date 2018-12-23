package com.itheima.dao;

import com.itheima.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IAccountDao {
    List <Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
}
