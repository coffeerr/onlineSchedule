package com.se.schedule.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Schedule;
import org.springframework.stereotype.Component;

@Component
public interface NoteMapper extends BaseMapper<Note> {
}
