package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.Schedule;
import com.se.schedule.mapper.ScheduleMapper;
import com.se.schedule.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/27 4:26 下午
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public int createSchedule(Schedule schedule) {
//        scheduleMapper.insert(schedule);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", schedule.getUserId());
        qw.eq("schedule_name", schedule.getScheduleName());
        Schedule s2 = scheduleMapper.selectOne(qw);
        if (s2 != null) {
            return -1;
        } else {
            s2.setCreateTime(new Date());
            scheduleMapper.insert(schedule);
            Schedule s3 = scheduleMapper.selectOne(qw);
            return s3.getScheduleId();
        }
    }

    @Override
    public Schedule getSchedule(int userId, int scheduleId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("schedule_id", scheduleId);
        Schedule schedule = scheduleMapper.selectOne(qw);
        return schedule;
    }

    @Override
    public List<Schedule> getScheduleList(int userID, String statusFlag) {
//        String key = "";
//        boolean keyFlag = true;
//        if (statusFlag.equals("pin")) {
//            key = "pin_flag";
//            keyFlag = true;
//        } else if (statusFlag.equals("nopin")) {
//            key = "pin_flag";
//            keyFlag = false;
//        }else if(statusFlag.equals("delete")){
//            key = "delete_flag";
//            keyFlag =
//        }
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userID);
        qw.eq("pin_flag", statusFlag);
        List<Schedule> list = scheduleMapper.selectList(qw);
        return list;
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", schedule.getUserId());
        qw.eq("schedule_id", schedule.getScheduleId());
        int rows = scheduleMapper.update(schedule, qw);
        return rows;
    }

    @Override
    public int deleteSchedule(int userId, int scheduleId, boolean recycle_bin) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("schedule_id", scheduleId);
        int rows;
        //如果回收站标志为否，则直接删除
        if (!recycle_bin) {
            rows = scheduleMapper.delete(qw);
        } else {
            Schedule schedule = new Schedule();
            schedule.setUserId(userId);
            schedule.setScheduleId(scheduleId);
            schedule.setBinFlag("false");
            schedule.setLastEditTime(new Date());
            rows = scheduleMapper.update(schedule, qw);
        }
        return rows;
    }
}
