package com.se.schedule.web.user.admin;

import com.se.schedule.entity.Tag;
import com.se.schedule.entity.User;
import com.se.schedule.service.AdminService;
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
 * @time: 2020/12/3 4:26 下午
 */
@Controller
@RequestMapping(value = "api/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUser(HttpServletRequest request) {
        String userName = HttpServletRequestUtil.getString(request, "user_name");
        Map<String, Object> map = new HashMap<>();
        User user = adminService.getUserByUserName(userName);
        if (user == null) {
            map.put("code", "ERROR");
            map.put("message", "获取用户信息失败!");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "获取用户信息成功！");
            map.put("data", user);
        }
        return map;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserList(HttpServletRequest request) {
        int startNum = HttpServletRequestUtil.getInt(request, "start_num");
        int endNum = HttpServletRequestUtil.getInt(request, "end_num");
        Map<String, Object> map = new HashMap<>();
        List<User> list = adminService.getUSerList(startNum, endNum);
        if (list.size() == 0) {
            map.put("code", "ERROR");
            map.put("message", "获取用户列表失败!");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "获取用户列表成功！");
            map.put("data", list);
        }
        return map;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        int rows = adminService.updateByAdmin(user);
        if (rows == 0) {
            map.put("code", "ERROR");
            map.put("message", "修改用户信息失败!");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "修改用户信息成功！");
            map.put("data", rows);
        }
        return map;
    }
}

