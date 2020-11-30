package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 9:00 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_todo_item")
public class TodoItem {
    @JsonProperty("todo_item_id")
    @TableField("todo_item_id")
    private int todoItemId;

    @JsonProperty("user_id")
    @TableField("user_id")
    private int userId;

    @JsonProperty("todo_id")
    @TableField("todo_id")
    private int todoId;

    @JsonProperty("todo_item_name")
    @TableField("todo_item_name")
    private String todoItemName;


    @JsonProperty("todo_item_status")
    @TableField("todo_item_status")
    private String todoItemStatus;


    @JsonProperty("create_time")
    @TableField("create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    @TableField("last_edit_time")
    private Date lastEditTime;
}
