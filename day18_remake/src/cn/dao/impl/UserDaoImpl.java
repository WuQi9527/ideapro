package cn.dao.impl;

import cn.dao.UserDao;
import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {

            String sql = "select *from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> finAll() {
        String sql = "select *from user";
        List<User> user = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delUser(int id) {
        String sql = "delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public User findUser(int id) {
        String sql = "select *from user where id=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name = ?,gender = ? ,age = ? , address = ? , qq = ?, email = ?where id=?";
        template.update(sql,user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount() {

        String sql="select count(*) from user";

        return template.queryForObject(sql,Integer.class);
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        String sql="select *from user limit ?,?";




        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),start,rows);


    }

}
