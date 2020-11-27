package com.se.schedule.service;

import com.se.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    /**
     * @param
     * @return
     * @Description: 新建⽇程
     * @author Desmand
     * @Date 2020/11/27
     */
    public int createSchedule(Schedule schedule);

    /**
     * @param
     * @return
     * @Description: 获取⽇程
     * @author Desmand
     * @Date 2020/11/27
     */
    public Schedule getSchedule(int userId, int scheduleId);

    /**
     * @param
     * @return
     * @Description: 获取⽇程列表
     * @author Desmand
     * @Date 2020/11/27
     */
    public List<Schedule> getScheduleList(int userID, String statusFlag);

    /**
     * @param
     * @return
     * @Description: 修改日程
     * @author Desmand
     * @Date 2020/11/27
     */
    public int updateSchedule(Schedule schedule);

    /**
     * @param
     * @return
     * @Description: 删除日程
     * @author Desmand
     * @Date 2020/11/27
     */
    public int deleteSchedule(int userId, int scheduleId, boolean recycle_bin);

}
