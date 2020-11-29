package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @description: 清单
 * @author: Desmand
 * @time: 2020/11/29 9:18 下午
 */

public class Todo {
    @JsonProperty("todo_id")
    @TableField("todo_id")
    private int todoId;

    @JsonProperty("todo_title")
    @TableField("todo_title")
    private String todoTitle;

    @JsonProperty("todo_list")
    @TableField("todo_list")
    private String todoList;

    @JsonProperty("create_time")
    @TableField("create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    @TableField("last_edit_time")
    private Date lastEditTime;
}
