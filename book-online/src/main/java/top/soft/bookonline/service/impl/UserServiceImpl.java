package top.soft.bookonline.service.impl;


import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaoImpl;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    /*    @param account 用户登录功能
     *@param password 密码
     @return
    */
    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        System.out.println(user.getPassword());
        System.out.println(user.getAccount());
        return userDao.findUser(user);
    }

    @Override
    public int register(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        System.out.println("注册密码"+user.getPassword());
        return userDao.insertUser(user);
    }
}