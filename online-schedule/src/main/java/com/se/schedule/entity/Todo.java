package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(value = "user_id")
    private int userId;

    @JsonProperty("note_id")
    @TableField("note_id")
    @TableId(value = "note_id")
    private int noteId;

    @JsonProperty("todo_id")
    @TableField("todo_id")
    @TableId(value = "todo_id")
    private int todoId;

    @JsonProperty("todo_title")
    @TableField("todo_title")
    @TableId(value = "todo_title")
    private String todoTitle;

    @JsonProperty("todo_list")
    @TableField("todo_list")
    @TableId(value = "todo_list")
    private String todoList;

    @JsonProperty("create_time")
    @TableField("create_time")
    @TableId(value = "create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    @TableField("last_edit_time")
    @TableId(value = "last_edit_time")
    private Date lastEditTime;
}
