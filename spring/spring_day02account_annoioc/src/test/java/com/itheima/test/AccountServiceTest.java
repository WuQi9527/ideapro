package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    @Test
    public void testFindAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        Account accountById = as.findAccountById(1);
        System.out.println(accountById);
    }
    @Test
    public void testSave(){
        Account account=new Account();
        account.setName("zhangsan");
        account.setMoney(1111f);
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        Account account=as.findAccountById(4);
        account.setMoney(2222f);
        account.setName("lisi");
        //as.saveAccount(account);
        as.updateAccount(account);

    }

    @Test
    public void testDelete(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);

        as.deleteAccount(5);
    }


}
