package com.se.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/27 4:12 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("schedule")
public class Schedule {
    private int scheduleId;
    private int userId;
    private String scheduleName;
    private String startPoint;
    private String curPoint;
    private String endPoint;
    private String pointUnit;
    private String barColor;
    private Date createTime;
    private Date lastEditTime;
    private String pinFlag;
    @TableField("bin_flag")
    private String binFlag;
}
