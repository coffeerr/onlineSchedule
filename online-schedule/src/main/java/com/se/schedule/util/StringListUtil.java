package com.se.schedule.util;

import com.se.schedule.entity.Schedule;
import com.se.schedule.entity.Todo;
import com.se.schedule.entity.TodoItem;

import java.util.*;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 9:21 下午
 */

public class StringListUtil {
    /**
     * @return java.util.List<java.lang.String>
     * @author Desmand
     * @Description: 清单分割，返回清单项列表
     * @Date 9:23 下午 2020/11/29
     * @Param [s]
     */
    public static List<TodoItem> getTodoItemList(Todo todo, String s) {
        List<TodoItem> list = new ArrayList<>();
        String[] strs = s.split("#");
        for (String i : strs) {
            TodoItem todoItem = new TodoItem();
            todoItem.setCreateTime(new Date());
            todoItem.setTodoId(todo.getTodoId());
            todoItem.setTodoItemName(i);
            todoItem.setUserId(todo.getUserId());
            list.add(todoItem);
        }
        return list;
    }

//    /**
//     * @return java.util.List<java.lang.String>
//     * @author Desmand
//     * @Description: 获得清单项列表
//     * @Date 3:50 下午 2020/11/30
//     * @Param [list]
//     */
//    public static List<String> getTodoItemList(List<TodoItem> list) {
//        List<String> nameList = new ArrayList<>();
//        if (list.size() == 0) return null;
//        for (TodoItem t : list) {
//            nameList.add(t.getTodoItemName());
//        }
//        return nameList;
//    }
//
//    /**
//     * @return java.util.HashMap<com.se.schedule.entity.TodoItem, java.lang.String>
//     * @author Desmand
//     * @Description: l1为前端返回获得的清单项列表，l2为数据库里获得的清单项列表
//     * @Date 3:52 下午 2020/11/30
//     * @Param [l1, l2]
//     */
//    public static HashMap<TodoItem, String> getUptadeList(List<TodoItem> l1, List<TodoItem> l2) {
//        Map<TodoItem, String> map = new HashMap<>();
//        List<String> updateList = getTodoItemList(l1);
//        List<String> sqlList = getTodoItemList(l2);
//        for (int i = 0; i < updateList.size(); i++) {
//            if (!sqlList.contains(updateList.get(i))) {
//                map.put(l1.get(i), "update");
//            }
//        }
//        for (int i = 0; i < sqlList.size(); i++) {
//            if (!sqlList.contains(updateList.get(i))) {
//                map.put(l1.get(i), "update");
//            }
//        }
//    }
}
