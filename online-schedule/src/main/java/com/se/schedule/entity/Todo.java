package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 清单
 * @author: Desmand
 * @time: 2020/11/29 9:18 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_todo")
public class Todo {
    @JsonProperty("user_id")
    @TableField("user_id")
    private int userId;

    @JsonProperty("note_id")
    @TableField("note_id")
    private int noteId;

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
