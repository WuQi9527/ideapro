package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll(){
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindById(){
        Account accountById = as.findAccountById(4);
        System.out.println(accountById);
    }
    @Test
    public void testUpdate(){
       Account account=new Account();
       account.setName("wwww");
       account.setMoney(5555f);
       account.setId(4);
       as.updateAccount(account);
    }
    @Test
    public void testSave(){
        Account account=new Account();
        account.setName("wwqq");
        account.setMoney(55555f);
        as.saveAccount(account);
    }

    @Test
    public void testDelete(){
        as.deleteAccount(5);
    }
}
