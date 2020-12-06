package com.se.schedule.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.se.schedule.entity.TodoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 8:02 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteModel {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("note_id")
    private int noteId;
    @JsonProperty("tag_id")
    private int tagId;

    @JsonProperty("note_title")
    private String noteTitle;

    @JsonProperty("remarks")
    private String remarks;


    @JsonProperty("pin_flag")
    private boolean pinFlag;

    @JsonProperty("delete_flag")
    private boolean recycleBin;

    @JsonProperty("modify_time")
    private Date lastEditTime;


    @JsonProperty("todo_list")
    @TableField("todo_list")
    private List<TodoItem> todoItemList;
}
