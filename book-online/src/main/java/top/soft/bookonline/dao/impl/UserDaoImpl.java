package top.soft.bookonline.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.util.JdbcUtil;
import top.soft.bookonline.util.Md5Util;

public class UserDaoImpl implements UserDao {
    //声明 JDBCTemplate 对象
        private final JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getDataSource());
        @Override
        public int insertUser(User user) {
            //1、编写 SQL
            String sql = "INSERT INTO t_user(account,password,nickname,avatar,address) VALUES (?, ?, ?, ?,?)";
            //2、调用 query 方法
            return jdbcTemplate.update(sql, user.getAccount(), Md5Util.crypt(user.getPassword()), user.getNickname(), user.getAvatar()
                    ,user.getAddress());
        }
            @Override
            public User findUser(User userDto){
                try {

                    String sql = "SELECT * FROM t_user WHERE account = ? AND password = ?";
                    //2、调用 query 方法,比对账号和加密后的密码
                    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>
                            (User.class), userDto.getAccount(), userDto.getPassword());
                } catch (DataAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
