package com.se.schedule.service;

import com.se.schedule.entity.Schedule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/27 4:36 下午
 */
@SpringBootTest
public class TestScheduleService {
    @Autowired
    ScheduleService scheduleService;

    @Test
    public void testCreateSchedule() {
        Schedule s = new Schedule();
        s.setScheduleName("test");
        s.setCreateTime(new Date());
        s.setUserId(1);
        int i = scheduleService.createSchedule(s);
        Assertions.assertEquals(i, 1);
    }

    @Test
    public void testGetSchedule() {
        int userID = 1;
        int scheduleId = 1;
        Schedule schedule = scheduleService.getSchedule(userID, scheduleId);
        Assertions.assertEquals(schedule.getScheduleId(), 1);
    }

    @Test
    public void testGetScheduleList() {
        int userId = 1;
        String pinFlag = "pin";
        List<Schedule> list = scheduleService.getScheduleList(userId, pinFlag);
        Assertions.assertEquals(list.size(), 2);
    }

    @Test
    public void testUpdateSchedule() {
        Schedule schedule = new Schedule();
        schedule.setUserId(1);
        schedule.setScheduleId(1);
        schedule.setScheduleName("testUpdate");
        schedule.setLastEditTime(new Date());
        int rows = scheduleService.updateSchedule(schedule);
        Assertions.assertEquals(rows, 1);
    }

    @Test
    public void testDeleteSchedule() {
        //删除日程
        int userId = 10;
        int scheduleId = 4;
        boolean bin_flag = false;
        int rows = scheduleService.deleteSchedule(userId, scheduleId, bin_flag);
        Assertions.assertEquals(rows,1);
    }
}
