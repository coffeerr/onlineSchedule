package com.se.schedule.service;

import com.se.schedule.entity.User;

public interface UserService {
    /**
     * @param
     * @return 用户
     * @Description: 登陆成功返回userID，失败返回-1
     * @author Desmand
     * @Date 2020/11/26
     */
    int loginByUserNameAndPwd(String userName, String pwd);

    /**
     * @param
     * @return ture or false
     * @Description: 注册
     * @author Desmand
     * @Date 2020/11/26
     */
    int signUpByUserNameAndPwd(String userName, String pwd);

    /**
     * @param
     * @return
     * @Description: ⽤户修改密码
     * @author Desmand
     * @Date 2020/11/26
     */
    boolean update(String userName, String oldPwd, String pwd);

    /**
     * @Description: 管理员修改密码
     * @param
     * @return
     * @author Desmand
     * @Date 2020/11/26
     */
    boolean updateByAdmin(int userId, String pwd);
}
