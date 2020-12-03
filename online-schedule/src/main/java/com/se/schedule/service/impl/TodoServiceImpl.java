package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.dto.TodoModel;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Todo;
import com.se.schedule.entity.TodoItem;
import com.se.schedule.mapper.TodoMapper;
import com.se.schedule.service.TodoItemService;
import com.se.schedule.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 10:36 下午
 */
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoMapper todoMapper;
    @Autowired
    TodoItemService todoItemService;


    @Override
    public int createTodo(Todo todo) {
        //新建清单需要新建清单项
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", todo.getUserId());
        qw.eq("note_id", todo.getNoteId());
        qw.eq("todo_title", todo.getTodoTitle());
        qw.eq("todo_list", todo.getTodoList());
        List<Todo> list = todoMapper.selectList(qw);
        if (list.size() > 0) {
            return -1;
        } else {
            int rows = todoMapper.insert(todo);
            if (rows > 0) {
                //新建清单项
                Todo returnNote = todoMapper.selectOne(qw);
                todoItemService.createTodoItemList(returnNote.getTodoList(), returnNote);
                return returnNote.getTodoId();
            } else {
                return -1;
            }
        }

    }

    @Override
    public TodoModel getTodo(int userId, int todoId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("todo_id", todoId);
        List<Todo> list = todoMapper.selectList(qw);
        List<TodoItem> todoItemList = todoItemService.getTodoItemList(todoId);
        List<TodoModel> returnList = new ArrayList<>();

        if (list.size() == 1) {
            Todo t = list.get(0);
            TodoModel todoModel = new TodoModel();
            todoModel.setCreateTime(t.getCreateTime());
            todoModel.setLastEditTime(t.getLastEditTime());
            todoModel.setTodoId(t.getTodoId());
            todoModel.setTodoItemList(todoItemList);
            todoModel.setTodoTitle(t.getTodoTitle());
            return todoModel;
        } else {
            return null;
        }
    }

    @Override
    public int updateTodo(Todo todo) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("todo_id", todo.getTodoId());
        todo.setLastEditTime(new Date());
        int rows = todoMapper.update(todo, qw);
        if (rows > 0) {
            //更新清单项目
            todoItemService.updateTodoItemList(todo.getTodoList(), todo);
            return todo.getTodoId();
        } else {
            return -1;
        }
    }

    @Override
    public int deleteTodo(Todo todo) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("todo_id", todo.getTodoId());
        int rows = todoMapper.delete(qw);
        if (rows > 0) {
            return todo.getTodoId();
        } else {
            return -1;
        }
    }
}
