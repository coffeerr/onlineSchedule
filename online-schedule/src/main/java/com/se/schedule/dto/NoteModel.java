package com.se.schedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @JsonProperty("recycle_bin")
    private boolean recycleBin;
}
