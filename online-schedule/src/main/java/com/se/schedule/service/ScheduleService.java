package com.se.schedule.service;

import com.se.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    /**
     * @return int
     * @author Desmand
     * @Description: 新建⽇程
     * @Date 6:01 下午 2020/11/28
     * @Param [schedule]
     */
    int createSchedule(Schedule schedule);

    /**
     * @return com.se.schedule.entity.Schedule
     * @author Desmand
     * @Description: 获取⽇程
     * @Date 6:02 下午 2020/11/28
     * @Param [userId, scheduleId]
     */
    Schedule getSchedule(int userId, int scheduleId);

    /**
     * @return java.util.List<com.se.schedule.entity.Schedule>
     * @author Desmand
     * @Description: 获取⽇程列表
     * @Date 6:02 下午 2020/11/28
     * @Param [userID, statusFlag]
     */
    List<Schedule> getScheduleList(int userID, String statusFlag);

    /**
     * @return int
     * @author Desmand
     * @Description: 修改日程
     * @Date 6:02 下午 2020/11/28
     * @Param [schedule]
     */
    int updateSchedule(Schedule schedule);

    /**
     * @return int
     * @author Desmand
     * @Description: 删除日程
     * @Date 6:02 下午 2020/11/28
     * @Param [userId, scheduleId, recycle_bin]
     */
    int deleteSchedule(int userId, int scheduleId, boolean recycle_bin);

}
