package com.se.schedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/26 6:33 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("account")
    private String userName;
    @JsonProperty("old_key")
    private String oldKey;
    @JsonProperty("New_key")
    private String newKey;
    @JsonProperty("key")
    private String key;


    private Date createDate;
    private Date lastEditDate;
}
