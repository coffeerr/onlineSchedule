package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.dto.NoteModel;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Schedule;
import com.se.schedule.mapper.NoteMapper;
import com.se.schedule.mapper.ScheduleMapper;
import com.se.schedule.service.NoteService;
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
    @Autowired
    private NoteService noteService;

    @Override
    public Map<String, List> getSearchKeyWord(String keyWord,int userId) {
        Map<String, List> map = new LinkedHashMap<>();
        //List<Object> list = new ArrayList<>();
        QueryWrapper scheduleQW = new QueryWrapper();
        QueryWrapper noteQW = new QueryWrapper();
        scheduleQW.like("schedule_name", keyWord);
        scheduleQW.eq("user_id",userId);
        List<Schedule> schedule_data = scheduleMapper.selectList(scheduleQW);
        List<NoteModel> note_data = noteService.getNoteListBySearch(keyWord,userId);
        if(schedule_data==null&&note_data==null){
            return map;
        }
        map.put("schedule_data", schedule_data);
        map.put("note_data", note_data);
        return map;
    }
}
