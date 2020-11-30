package com.se.schedule.web.todo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.dto.TodoModel;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Todo;
import com.se.schedule.service.NoteService;
import com.se.schedule.service.TodoService;
import com.se.schedule.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/30 2:44 下午
 */

@Controller
@RequestMapping(value = "api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createTodo(@RequestBody Todo todo) {
        Map<String, Object> map = new HashMap<>();
        int rows = todoService.createTodo(todo);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "新建清单成功");
            map.put("data", rows);
        } else {
            map.put("code", "ERROR");
            map.put("message", "新建清单失败");
            map.put("data", rows);
        }
        return map;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTodo(HttpServletRequest request) {
        int userId = HttpServletRequestUtil.getInt(request, "user_id");
        int todoId = HttpServletRequestUtil.getInt(request, "todo_id");
        Map<String, Object> map = new HashMap<>();
        TodoModel todomodel = todoService.getTodo(userId, todoId);
        if (todomodel != null) {
            map.put("code", "OK");
            map.put("message", "获取清单成功");
            map.put("data", todomodel);
        } else {
            map.put("code", "ERROR");
            map.put("message", "获取清单失败");
            map.put("data", "");
        }
        return map;
    }


    @RequestMapping(value = "/todo", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateTodo(@RequestBody Todo todo) {
        Map<String, Object> map = new HashMap<>();
        int rows = todoService.updateTodo(todo);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "修改清单成功");
            map.put("data", rows);
        } else {
            map.put("code", "ERROR");
            map.put("message", "修改清单失败");
            map.put("data", rows);
        }
        return map;
    }

    @RequestMapping(value = "/todo", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteTodo(@RequestBody Todo todo) {
        Map<String, Object> map = new HashMap<>();
        int rows = todoService.deleteTodo(todo);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "删除清单成功");
            map.put("data", rows);
        } else {
            map.put("code", "ERROR");
            map.put("message", "删除清单失败");
            map.put("data", rows);
        }
        return map;
    }

}