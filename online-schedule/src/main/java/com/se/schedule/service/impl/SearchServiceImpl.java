package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Schedule;
import com.se.schedule.mapper.NoteMapper;
import com.se.schedule.mapper.ScheduleMapper;
import com.se.schedule.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 9:58 上午
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    NoteMapper noteMapper;
    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public Map<String, List> getSearchKeyWord(String keyWord) {
        Map<String, List> map = new LinkedHashMap<>();
        //List<Object> list = new ArrayList<>();
        QueryWrapper scheduleQW = new QueryWrapper();
        QueryWrapper noteQW = new QueryWrapper();
        scheduleQW.like("schedule_name", keyWord);
        noteQW.like("note_title", keyWord);
        List<Schedule> schedule_data = scheduleMapper.selectList(scheduleQW);
        List<Note> note_data = noteMapper.selectList(noteQW);
        map.put("schedule_data", schedule_data);
        map.put("note_data", note_data);
        return map;
    }
}
