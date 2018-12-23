package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 用户登录方法
     *
     * @param user
     * @return
     */
    public User login(User user) {
        try {
            User existUser = template.queryForObject("select * from user where username = ? and password = ?",
                    new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return existUser;
        } catch (DataAccessException e) {
            // 查询不到.返回null
            return null;
        }

    }
}
