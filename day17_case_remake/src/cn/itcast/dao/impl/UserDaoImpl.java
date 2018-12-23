package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
   /* public List<User> findAll() {
        //使用jdbc操作数据库
        String sql="select *from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }*/
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }@Override
     public User findUserByusernameAndPassword(String username, String password){

        try {

        String sql="select *from user where username=? and password=?";
         User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
         return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
     }

    @Override
    public void addUser(User user) {
        String sql="insert into user values (null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delete(int id) {
        String sql="delete from user where id=?";

        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
        String sql="select * from user where id=?";
     return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);

    }

    @Override
    public void updateUser(User user) {
        String sql="update user set  name=?,gender=?,age=?,address=?,qq=?,email=? where id =?";
       // String sql="insert into user values (null,?,?,?,?,?,?,null,null)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());

    }



}
