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
 * @time: 2020/12/1 9:18 上午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_tag")
public class Tag {
    @JsonProperty("user_id")
    @TableField("user_id")
    @TableId(value = "user_id")
    private int userId;

    @JsonProperty("tag_id")
    @TableField("tag_id")
    @TableId(value = "tag_id")
    private int tagId;

    @JsonProperty("tag_title")
    @TableField("tag_title")
    @TableId(value = "tag_title")
    private String tagTitle;


    @JsonProperty("create_time")
    @TableField("create_time")
    @TableId(value = "create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    @TableField("last_edit_time")
    @TableId(value = "last_edit_time")
    private Date lastEditTime;
}
