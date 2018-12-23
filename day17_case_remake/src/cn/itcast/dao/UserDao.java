package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    User findUserByusernameAndPassword(String username, String password);

    void addUser(User user);

    void delete(int parseInt);

    User findById(int parseInt);

    void updateUser(User user);


}
