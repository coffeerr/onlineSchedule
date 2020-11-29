package com.se.schedule.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.se.schedule.entity.Todo;
import com.se.schedule.entity.TodoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 10:39 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoModel {
    @JsonProperty("todo_id")
    @TableField("todo_id")
    private int todoId;

    @JsonProperty("todo_title")
    @TableField("todo_title")
    private String todoTitle;

    @JsonProperty("todo_list")
    @TableField("todo_list")
    private List<TodoItem> todoList;

    @JsonProperty("create_time")
    @TableField("create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    @TableField("last_edit_time")
    private Date lastEditTime;
}
