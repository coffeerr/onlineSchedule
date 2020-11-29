package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.TodoItem;
import com.se.schedule.mapper.TodoItemMapper;
import com.se.schedule.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 9:07 下午
 */
@Service
public class TodoItemServiceImpl implements TodoItemService {
    @Autowired
    TodoItemMapper todoItemMapper;

    @Override
    public List<TodoItem> getTodoItemList(int todoId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("todo_id", todoId);
        List<TodoItem> list = todoItemMapper.selectList(qw);
        return list;
    }

    @Override
    public int updateTodoItem(TodoItem todoItem) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("todo_item_id", todoItem.getTodoItemId());
        int rows = todoItemMapper.update(todoItem, qw);
        if (rows > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteTodoItem(TodoItem todoItem) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("todo_item_id", todoItem.getTodoItemId());
        int rows = todoItemMapper.delete(qw);
        if (rows > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
