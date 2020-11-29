package com.se.schedule.service;

import com.se.schedule.entity.TodoItem;

import java.util.List;

public interface TodoItemService {
    /**
     * @return java.util.List<com.se.schedule.entity.TodoItem>
     * @author Desmand
     * @Description: 获得清单项列表，从todoId里的字符串得到'#'解析出list
     * @Date 9:06 下午 2020/11/29
     * @Param [todoId]
     */
    List<TodoItem> getTodoItemList(int todoId);

    /**
     * @return int
     * @author Desmand
     * @Description: 修改清单项
     * @Date 9:05 下午 2020/11/29
     * @Param [todoItem]
     */
    int updateTodoItem(TodoItem todoItem);

    /**
     * @return int
     * @author Desmand
     * @Description: 删除清单项
     * @Date 9:04 下午 2020/11/29
     * @Param [todoItem]
     */
    int deleteTodoItem(TodoItem todoItem);

}
