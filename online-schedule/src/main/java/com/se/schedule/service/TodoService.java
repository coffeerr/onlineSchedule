package com.se.schedule.service;

import com.se.schedule.entity.Todo;
import com.se.schedule.entity.TodoItem;

public interface TodoService {
    /**
     * @return int
     * @author Desmand
     * @Description: 创建清单
     * @Date 10:23 下午 2020/11/29
     * @Param [todo]
     */
    int createTodo(Todo todo);

    /**
     * @return com.se.schedule.entity.
     * @author Desmand
     * @Description: 获得清单
     * @Date 10:24 下午 2020/11/29
     * @Param [userId, todoId]
     */
    Todo getTodo(int userId, int todoId);

    /**
     * @return int
     * @author Desmand
     * @Description: 修改Todo
     * @Date 10:27 下午 2020/11/29
     * @Param [todo]
     */
    int updateTodo(Todo todo);

    /**
     * @return int
     * @author Desmand
     * @Description: 删除清单
     * @Date 10:28 下午 2020/11/29
     * @Param [todo]
     */
    int deleteTodo(Todo todo);
}
