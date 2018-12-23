package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.domain.PageBean;
import cn.domain.User;
import cn.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDaoImpl dao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public User findUserById(String id) {
        return dao.findUser(Integer.parseInt(id));
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectUser(String[] uids) {

        if (uids != null && uids.length > 0) {
            for (String ids : uids) {
                dao.delUser(Integer.parseInt(ids));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows=Integer.parseInt(_rows);
        if (currentPage<=0){
            currentPage=1;
        }
        PageBean<User> pb=new PageBean<User>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        int totalCount=dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询list集合
        //计算开始的索引
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows,condition);
        pb.setList(list);
        //计算总页码
        int totalPage=(totalCount%5)==0 ? totalCount/rows : (totalCount/rows)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
