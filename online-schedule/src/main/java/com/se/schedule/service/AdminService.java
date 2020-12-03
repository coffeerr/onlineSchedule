package com.se.schedule.service;

import com.se.schedule.entity.User;

import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/3 3:50 下午
 */

public interface AdminService {
    /**
     * @return com.se.schedule.entity.User
     * @author Desmand
     * @Description: 获得用户名
     * @Date 4:24 下午 2020/12/3
     * @Param [keywords]
     */
    User getUserByUserName(String keywords);

    /**
     * @return java.util.List<com.se.schedule.entity.User>
     * @author Desmand
     * @Description: 获取指定个数的user
     * @Date 3:53 下午 2020/12/3
     * @Param [startNum, endNum]
     */
    List<User> getUSerList(int startNum, int endNum);

    /**
     * @return int
     * @author Desmand
     * @Description: 管理员修改用户
     * @Date 4:21 下午 2020/12/3
     * @Param [user]
     */
    int updateByAdmin(User user);
}
