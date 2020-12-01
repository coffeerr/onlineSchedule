package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.Todo;
import com.se.schedule.entity.TodoItem;
import com.se.schedule.mapper.TodoItemMapper;
import com.se.schedule.service.TodoItemService;
import com.se.schedule.util.StringListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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


    @Override
    public int updateTodoItemList(String todoItemList, Todo todo) {
        List<TodoItem> updateList = StringListUtil.getTodoItemList(todo, todoItemList);
        QueryWrapper getListQW = new QueryWrapper();
        getListQW.eq("todo_id", updateList.get(0).getTodoId());
        List<TodoItem> originList = todoItemMapper.selectList(getListQW);
        //删除
        if (updateList.size() > 0 && updateList.get(0).getTodoId() == originList.get(0).getTodoId()) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("todo_id", originList.get(0).getTodoId());
            todoItemMapper.delete(qw);
        }
        //更新
        for (TodoItem t : updateList) {
            t.setLastEditTime(new Date());
            todoItemMapper.insert(t);
        }

//        int rows = 0;
//        for (TodoItem todoItem : list) {
//            rows += todoItemMapper.insert(todoItem);
//        }
        return 0;
    }


    @Override
    public int createTodoItemList(String todoItemList, Todo todo) {
        String[] nameList = todoItemList.split("#");
        List<TodoItem> list = new ArrayList<>();
        for (String s : nameList) {
            TodoItem todoItem = new TodoItem();
            todoItem.setTodoItemName(s);
            todoItem.setUserId(todo.getUserId());
            todoItem.setCreateTime(new Date());
            todoItem.setTodoId(todo.getTodoId());
            list.add(todoItem);
//            todoItem.setTodoItemStatus();
        }
        int rows = 0;
        for (TodoItem todoItem : list) {
            rows += todoItemMapper.insert(todoItem);
        }
        return 0;
    }

}
