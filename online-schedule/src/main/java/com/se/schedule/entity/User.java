package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/26 2:51 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user") //对应表名
public class User implements Serializable {
    @JsonProperty("user_id")
    @TableId(value = "user_id")
    private int userId;

    @JsonProperty("user_name")
    @TableField("user_name")
    private String userName;

    @JsonProperty("password")
    @TableField("password")
    private String password;

    @JsonProperty("create_time")
    @TableField("create_time")
    private Date createTime;


    @JsonProperty("last_edit_time")
    @TableField("last_edit_time")
    private Date lastEditTime;
}
