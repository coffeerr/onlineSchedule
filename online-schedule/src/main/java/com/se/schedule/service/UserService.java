package com.se.schedule.service;

import com.se.schedule.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    /**
     * @return int
     * @author Desmand
     * @Description: 验证登陆 成功返回userID，失败返回-1
     * @Date 6:03 下午 2020/11/28
     * @Param [userName, pwd]
     */
    int loginByUserNameAndPwd(String userName, String pwd);

    /**
     * @return int
     * @author Desmand
     * @Description: 注册用户
     * @Date 6:03 下午 2020/11/28
     * @Param [userName, pwd]
     */
    int signUpByUserNameAndPwd(String userName, String pwd);

    /**
     * @return boolean
     * @author Desmand
     * @Description: 修改用户
     * @Date 6:03 下午 2020/11/28
     * @Param [userName, oldPwd, pwd]
     */
    boolean update(String userName, String oldPwd, String pwd);

    /**
     * @return boolean
     * @author Desmand
     * @Description: 管理员修改用户
     * @Date 6:04 下午 2020/11/28
     * @Param [userId, pwd]
     */
    boolean updateByAdmin(int userId, String pwd,int scheduleNum,int noteNum);
}
