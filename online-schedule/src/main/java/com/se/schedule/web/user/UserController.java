package com.se.schedule.web.user;

import com.se.schedule.dto.UserModel;
import com.se.schedule.entity.User;
import com.se.schedule.service.AdminService;
import com.se.schedule.service.UserService;
import com.se.schedule.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/26 4:17 下午
 */
@Controller
@RequestMapping(value = "api", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> loginCheck(@RequestBody UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        // 获取输入的帐号
        String userName = userModel.getUserName();
        // 获取输入的密码
        String password = userModel.getKey();


        int loginCode = userService.loginByUserNameAndPwd(userName, password);
        if (loginCode == -1) {
            map.put("code", "ERROR");
            map.put("message", "用户名或密码输入错误！");
            map.put("data", loginCode);
        } else {
            map.put("code", "OK");
            map.put("message", "登陆成功！");
            map.put("data", loginCode);
        }
        return map;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> signUp(@RequestBody UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        // 获取输入的帐号
        String userName = userModel.getUserName();
        // 获取输入的密码
        String password = userModel.getKey();

        int loginCode = userService.signUpByUserNameAndPwd(userName, password);
        if (loginCode == -1) {
            map.put("code", "ERROR");
            map.put("message", "注册失败！");
            map.put("data", loginCode);
        } else {
            map.put("code", "OK");
            map.put("message", "注册成功！");
            map.put("data", loginCode);
        }
        return map;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    private Map<String, Object> update(@RequestBody UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        // 获取输入的帐号
        String userName = userModel.getUserName();
        // 获取输入的密码
        String oldPwd = userModel.getOldKey();
        String pwd = userModel.getNewKey();

        boolean flag = userService.update(userName, oldPwd, pwd);
        if (!flag) {
            map.put("code", "ERROR");
            map.put("message", "修改用户失败！");
            map.put("data", "");
        } else {
            map.put("code", "OK");
            map.put("message", "修改用户成功！");
            map.put("data", "");
        }
        return map;
    }

    @RequestMapping(value = "/user/admin", method = RequestMethod.PUT)
    @ResponseBody
    private Map<String, Object> updateByAdmin(@RequestBody UserModel userModel) {
        Map<String, Object> map = new HashMap<>();
        int userId = userModel.getUserId();
        // 获取输入的密码
        String password = userModel.getKey();
        int scheduleNum = userModel.getScheduleNum();
        int noteNum = userModel.getNoteNum();

        boolean isUpdatedByAdmin = userService.updateByAdmin(userId, password,scheduleNum,noteNum);
        if (!isUpdatedByAdmin) {
            map.put("code", "ERROR");
            map.put("message", "管理员修改用户失败！");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "管理员修改用户成功！");
            map.put("data", 1);
        }
        return map;
    }
}
