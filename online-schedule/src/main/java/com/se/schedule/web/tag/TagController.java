package com.se.schedule.web.tag;

import com.se.schedule.dto.ScheduleModel;
import com.se.schedule.entity.Schedule;
import com.se.schedule.entity.Tag;
import com.se.schedule.service.ScheduleService;
import com.se.schedule.service.TagService;
import com.se.schedule.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 9:38 上午
 */
@Controller
@RequestMapping(value = "api")
public class TagController {
    @Autowired
    TagService tagService;

    @RequestMapping(value = "/tag", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createTag(@RequestBody Tag tag) {
        tag.setCreateTime(new Date());
        Map<String, Object> map = new HashMap<>();
        int tagId = tagService.createTag(tag);
        if (tagId == -1) {
            map.put("code", "ERROR");
            map.put("message", "创建标签失败");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "创建标签成功");
            map.put("data", tagId);
        }
        return map;
    }

    @RequestMapping(value = "/tag/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTagList(HttpServletRequest request) {
        int userId = HttpServletRequestUtil.getInt(request, "user_id");
        Map<String, Object> map = new HashMap<>();
        List<Tag> list = tagService.getTagList(userId);
        if (list.size() < 1) {
            map.put("code", "ERROR");
            map.put("message", "获取标签列表失败");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "获取标签列表成功");
            map.put("data", list);
        }
        return map;
    }

    @RequestMapping(value = "/tag", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateSchedule(@RequestBody Tag tag) {
        Map<String, Object> map = new HashMap<>();
        tag.setLastEditTime(new Date());
        int rows = tagService.updateTag(tag);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "修改标签成功");
            map.put("data", 1);
        } else {
            map.put("code", "ERROR");
            map.put("message", "修改标签失败");
            map.put("data", -1);
        }
        return map;
    }

    @RequestMapping(value = "/tag", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteSchedule(@RequestBody Tag tag) {
        Map<String, Object> map = new HashMap<>();
        //int userId, int scheduleId, boolean recycle_bin
        int rows = tagService.deleteTag(tag);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "删除标签成功");
            map.put("data", 1);
        } else {
            map.put("code", "ERROR");
            map.put("message", "删除标签失败");
            map.put("data", -1);
        }
        return map;
    }
}
