package com.se.schedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/27 10:08 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleModel {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("recycle_bin")
    private boolean recycleBin;
}
