package com.se.schedule.service;

import com.se.schedule.entity.Todo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/30 2:24 下午
 */

@SpringBootTest
public class TestTodoService {
    @Autowired
    TodoService todoService;

    @Test
    @Ignore
    public void testACreateTodo() {
        Todo todo = new Todo();
        todo.setCreateTime(new Date());
        todo.setNoteId(5);
        todo.setUserId(5);
        todo.setTodoTitle("test");
        todo.setTodoList("做饭#洗衣服#睡觉");
        int rows = todoService.createTodo(todo);
        //Assertions.assertEquals(rows, 1);
    }
}
