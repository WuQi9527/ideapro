package com.itheima.ui;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountServvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountServvice as= (AccountServvice) ac.getBean("accountService");
        AccountDao dao=ac.getBean("accountDao",AccountDao.class);
        System.out.println(as);
        System.out.println(dao);
        as.saveAccount();
        System.out.println();
    }
}
