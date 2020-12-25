package com.se.schedule.web.schedule;

import com.se.schedule.dto.ScheduleModel;
import com.se.schedule.entity.Schedule;
import com.se.schedule.service.ScheduleService;
import com.se.schedule.util.HttpServletRequestUtil;
import com.se.schedule.enums.ScheduleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.se.schedule.util.DateUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/27 5:20 下午
 */
@Controller
@RequestMapping(value = "api")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    /**
     * @param
     * @return
     * @Description: 新建日程
     * @author Desmand
     * @Date 2020/11/27
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createSchedule(@RequestBody Schedule schedule) {
        Map<String, Object> map = new HashMap<>();
        schedule.getScheduleId();
        int scheduleId = scheduleService.createSchedule(schedule);
//        if (!DateUtil.isDateLegal(Integer.parseInt(
//                schedule.getStartPoint()), Integer.parseInt(schedule.getCurPoint()), Integer.parseInt(schedule.getEndPoint()))) {
//            map.put("code", "ERROR");
//            map.put("message", "创建⽇程失败");
//            map.put("data", scheduleId);
//            return map;
//        }
        if (scheduleId == 999) {
            map.put("code", "ERROR");
            map.put("message", "达到日程上限");
            map.put("data", -1);
        } else if (scheduleId > 0) {
            map.put("code", "OK");
            map.put("message", "创建⽇程成功");
            map.put("data", scheduleId);
        } else {
            map.put("code", "ERROR");
            map.put("message", "创建⽇程失败");
            map.put("data", scheduleId);
        }
        return map;
    }

    /**
     * @param
     * @return
     * @Description: 获取日程
     * @author Desmand
     * @Date 2020/11/27
     */
    @RequestMapping(value = "/schedule", method = RequestMethod.GET, params = "user_id")
    @ResponseBody
    public Map<String, Object> getSchedule(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        // 获取输入的用户id
        int userId = HttpServletRequestUtil.getInt(request, "user_id");
        // 获取输入的日程id
        int scheduleId = HttpServletRequestUtil.getInt(request, "schedule_id");
        Schedule schedule = scheduleService.getSchedule(userId, scheduleId);
        if (schedule == null) {
            map.put("code", "ERROR");
            map.put("message", "获得⽇程失败");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "获得⽇程成功");
            map.put("data", schedule);
        }
        return map;
    }

    @RequestMapping(value = "/schedule/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScheduleList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 获取输入的用户id
        int userId = HttpServletRequestUtil.getInt(request, "user_id");
        // 获取输入的日程id
        String statusFlag = HttpServletRequestUtil.getString(request, "status_flag");

        List<Schedule> list = scheduleService.getScheduleList(userId, statusFlag);
        if (list.size() > 0) {
            map.put("code", "OK");
            map.put("message", "获取⽇程列表成功");
            map.put("data", list);
        } else {
            if (statusFlag == null || statusFlag.equals("")) {
                map.put("code", ScheduleEnum.NO_SCHEDULE_ERROR.getCode());
                map.put("message", ScheduleEnum.NO_SCHEDULE_ERROR.getMsg());
                map.put("data", -1);
            } else if (statusFlag.equals("pin")) {
                map.put("code", ScheduleEnum.NO_PIN_SCHEDULE_ERROR.getCode());
                map.put("message", ScheduleEnum.NO_PIN_SCHEDULE_ERROR.getMsg());
                map.put("data", -1);
            } else if (statusFlag.equals("nopin")) {
                map.put("code", ScheduleEnum.NO_UNPIN_SCHEDULE_ERROR.getCode());
                map.put("message", ScheduleEnum.NO_UNPIN_SCHEDULE_ERROR.getMsg());
                map.put("data", -1);
            } else if (statusFlag.equals("delete")) {
                map.put("code", ScheduleEnum.NO_RECYCLE_SCHEDULE_ERROR.getCode());
                map.put("message", ScheduleEnum.NO_RECYCLE_SCHEDULE_ERROR.getMsg());
                map.put("data", -1);
            }
        }
        return map;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateSchedule(@RequestBody Schedule schedule) {
        Map<String, Object> map = new HashMap<>();
        schedule.setLastEditTime(new Date());
        try {
            int rows = scheduleService.updateSchedule(schedule);
            if (rows > 0) {
                map.put("code", "OK");
                map.put("message", "修改日程成功");
                map.put("data", 1);
            } else {
                map.put("code", "ERROR");
                map.put("message", "修改日程失败");
                map.put("data", -1);
            }
        } catch (Exception e) {
            map.put("code", "ERROR");
            map.put("message", "修改日程失败");
            map.put("data", e.toString());
        }
        return map;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteSchedule(@RequestBody ScheduleModel scheduleModel) {
        Map<String, Object> map = new HashMap<>();
        //int userId, int scheduleId, boolean recycle_bin
        int userId = scheduleModel.getUserId();
        int scheduleId = scheduleModel.getScheduleId();
        boolean recycleBin = scheduleModel.isRecycleBin();
        int rows = scheduleService.deleteSchedule(userId, scheduleId, recycleBin);
        if (rows == 1) {
            map.put("code", "OK");
            map.put("message", "移入回收站成功");
            map.put("data", 1);
        } else if (rows == -1) {
            map.put("code", "ERROR");
            map.put("message", "移入回收站失败");
            map.put("data", -1);
        } else if (rows == 2) {
            map.put("code", "OK");
            map.put("message", "删除日程成功");
            map.put("data", 2);
        } else if (rows == -2) {
            map.put("code", "OK");
            map.put("message", "删除日程成功");
            map.put("data", -2);
        }
        return map;
    }

    @RequestMapping(value = "/schedule/restore", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> restoreSchedule(@RequestBody Schedule schedule) {
        Map<String, Object> map = new HashMap<>();
        schedule.setLastEditTime(new Date());
        int rows = scheduleService.restoreSchedule(schedule.getUserId(), schedule.getScheduleId());
        if (rows == 999) {
            map.put("code", "ERROR");
            map.put("message", "达到日程上限");
            map.put("data", -1);
        } else if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "还原日程成功");
            map.put("data", 1);
        } else {
            map.put("code", "ERROR");
            map.put("message", "无回收日程");
            map.put("data", -1);
        }
        return map;
    }
}
