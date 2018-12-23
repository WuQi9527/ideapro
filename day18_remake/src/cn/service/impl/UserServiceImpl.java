package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.domain.PageBean;
import cn.domain.User;
import cn.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao=new UserDaoImpl();
    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public List<User> findAll() {

        return  dao.finAll();
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void delUser(int id) {
        dao.delUser(id);
    }

    @Override
    public User findUser(int id) {
        return dao.findUser(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectUser(String[] uids) {
        for (String uid : uids) {
            dao.delUser(Integer.parseInt(uid));
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage=Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<User> pb=new PageBean<User>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        int totalCount=dao.findTotalCount();
        pb.setTotalCount(totalCount);

        int start=(currentPage-1)*rows;
        List<User>list=dao.findByPage(start,rows);
        pb.setList(list);

        int totalPage=totalCount%rows==0  ? totalCount/rows : totalCount/rows+1;
        pb.setTotalPage(totalPage);
        return pb;
    }


}
