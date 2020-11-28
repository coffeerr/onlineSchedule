package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @TableId(value = "user_id")
    private int userId;

    @JsonProperty("todo_id")
    @TableId(value = "todo_id")
    private int todoId;

    private String remarks;

    @JsonProperty("tag_id")
    @TableId(value = "tag_id")
    private int tagId;
}
