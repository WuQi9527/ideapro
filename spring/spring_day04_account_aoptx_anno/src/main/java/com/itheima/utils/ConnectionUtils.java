package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> t1=new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;


    public Connection getThreadConnection(){
        try {
            Connection conn=t1.get();
            if (conn==null){
                conn=dataSource.getConnection();
                t1.set(conn);
            }
            return conn;
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
    public  void removeConnection(){
        t1.remove();
    }
}
