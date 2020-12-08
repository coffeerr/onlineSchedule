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
 * @time: 2020/11/27 4:12 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_schedule")
public class Schedule {
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("schedule_name")
    private String scheduleName;
    @JsonProperty("start_point")
    private String startPoint;
    @JsonProperty("cur_point")
    private String curPoint;
    @JsonProperty("end_point")
    private String endPoint;
    @JsonProperty("point_unit")
    private String pointUnit;
    @JsonProperty("bar_color")
    private String barColor;
    @JsonProperty("create_time")
    private Date createTime;
    @JsonProperty("modify_time")
    private Date lastEditTime;
    @JsonProperty("pin_flag")
    private String pinFlag;
    @JsonProperty("delete_flag")
    @TableField("bin_flag")
    private String binFlag;

}
