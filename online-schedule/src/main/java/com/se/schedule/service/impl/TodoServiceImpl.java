package com.se.schedule.service.impl;

import com.se.schedule.entity.Todo;
import com.se.schedule.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 10:36 下午
 */
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired

    @Override
    public int createTodo(Todo todo) {

        return 0;
    }

    @Override
    public Todo getTodo(int userId, int todoId) {
        return null;
    }

    @Override
    public int updateTodo(Todo todo) {
        return 0;
    }

    @Override
    public int deleteTodo(Todo todo) {
        return 0;
    }
}
