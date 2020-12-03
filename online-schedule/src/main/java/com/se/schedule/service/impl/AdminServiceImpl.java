package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.se.schedule.entity.User;
import com.se.schedule.mapper.UserMapper;
import com.se.schedule.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/3 3:54 下午
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_name", userName);
        User user = userMapper.selectOne(qw);
        return user;
    }

    @Override
    public List<User> getUSerList(int startNum, int endNum) {
        QueryWrapper qw = new QueryWrapper();
        qw.orderByAsc("user_id");
        List<User> list = userMapper.selectList(qw);
        List<User> returnList = new ArrayList<>();
        for (int i = startNum; i <= endNum; i++) {
            returnList.add(list.get(i));
        }
        return returnList;
    }


    @Override
    public int updateByAdmin(User user) {
//        user_id：用户 id，数字
//        key：密码，字符串（允许为空，""则不修改）
//        schedule_num：日程上限，数字（-1则不修改）
//        note_num：记事上限，数字（-1则不修改）
        UpdateWrapper<User> uw = new UpdateWrapper<>();
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", user.getUserId());
        User updateUser = userMapper.selectById(user.getUserId());
        uw.eq("user_id", updateUser.getUserId());
        if (user.getPassword() != null && !user.getPassword().equals("")) {
            uw.set("password", user.getPassword());
        }
        if (user.getScheduleNum() != -1) {
            uw.set("schedule_num", user.getScheduleNum());
        }
        if (user.getNoteNum() != -1) {
            uw.set("note_num", user.getNoteNum());
        }
        uw.set("last_edit_time", new Date());
        int rows = userMapper.update(updateUser, uw);
        if (rows > 0) {
            return user.getUserId();
        } else {
            return -1;
        }
    }
}
