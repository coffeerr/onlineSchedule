package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableId(value = "user_id")
    private int userId;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("create_time")
    private Date createTime;

    @TableField("last_edit_time")
    private Date lastEditTime;
}
