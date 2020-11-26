package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.User;
import com.se.schedule.mapper.UserMapper;
import com.se.schedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/26 3:26 下午
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int loginByUserNameAndPwd(String userName, String pwd) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pwd);
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("user_name", userName);
        qw.eq("password", pwd);
        User user2 = userMapper.selectOne(qw);
        if (user2 == null) return -1;
        return user2.getUserId();
    }

    @Override
    public int signUpByUserNameAndPwd(String userName, String pwd) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(pwd);
        user.setCreateTime(new Date());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_name", userName);
        User user2 = userMapper.selectOne(qw);
        if (user2 != null) {
            //注册失败，用户名存在
            return -1;
        } else {
            userMapper.insert(user);
            QueryWrapper qw2 = new QueryWrapper();
            qw2.eq("user_name", userName);
            User user3 = userMapper.selectOne(qw2);
            return user3.getUserId();
        }
    }

    @Override
    public boolean update(String userName, String oldPwd, String pwd) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_name", userName);
        qw.eq("password", oldPwd);
        User user = userMapper.selectOne(qw);
        if (user == null) {
            return false;
        } else {
            User user2 = new User();
            user2.setUserName(userName);
            user2.setPassword(pwd);
            QueryWrapper qw2 = new QueryWrapper();
            qw2.eq("user_name", userName);
            int rows = userMapper.update(user2, qw2);
            if (rows == 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateByAdmin(int userId, String pwd) {
        QueryWrapper qw1 = new QueryWrapper();
        qw1.eq("user_id", userId);
        User user = new User();
        user.setUserId(userId);
        user.setPassword(pwd);
        int rows = userMapper.update(user, qw1);
        if (rows > 0) {
            return true;
        }
        return false;
    }


}
