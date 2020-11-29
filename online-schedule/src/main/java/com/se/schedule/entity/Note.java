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
 * @description:
 * @author: Desmand
 * @time: 2020/11/28 5:28 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_note")
public class Note {
    @JsonProperty("note_id")
    @TableField("note_id")
    private int noteId;

    @JsonProperty("note_title")
    @TableField("note_title")
    private String noteTitle;

    @JsonProperty("user_id")
    @TableField("user_id")
    private int userId;

    @JsonProperty("todo_id")
    @TableField("todo_id")
    private int todoId;


    @JsonProperty("remarks")
    @TableField("remarks")
    private String remarks;

    @JsonProperty("tag_id")
    @TableField("tag_id")
    private int tagId;


    @JsonProperty("create_time")
    @TableField("create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    @TableField("modify_time")
    private Date lastEditTime;

    @JsonProperty("pin_flag")
    @TableField("pin_flag")
    private String pinFlag;

    @JsonProperty("delete_flag")
    @TableField("delete_flag")
    private String binFlag;
}
