package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.Note;
import com.se.schedule.mapper.NoteMapper;
import com.se.schedule.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public int createNote(Note note) {
        note.setCreateTime(new Date());
        int rows = noteMapper.insert(note);
        if (rows > 0) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("user_id", note.getUserId());
            qw.eq("note_title", note.getNoteTitle());
            qw.eq("remarks", note.getRemarks());
            Note note2 = noteMapper.selectOne(qw);
            return note2.getNoteId();
        } else {
            return -1;
        }
//        user_id：⽤户 id，数字
//        note_title：记事标题，字符串
//        todo_id：清单 id，数字
//        remarks：备注字段，字符串
//        pin_flag：固定标记，布尔值（true/false）
//        tag_id：标签 id，数字
    }

    @Override
    public Note getNote(int userId, int noteId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("note_id", noteId);
        Note note = noteMapper.selectOne(qw);
        if (note != null) {
            return note;
        } else {
            return null;
        }

    }

    @Override
    public List<Note> getNoteList(int userId, int tagId, String statusFlag) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("tag_id", tagId);
        qw.eq("pin_flag", statusFlag);
        List<Note> list = noteMapper.selectList(qw);
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int updateNote(Note note) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("note_id", note.getNoteId());
        int rows = noteMapper.update(note, qw);
        if (rows > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteNote(int userId, int noteId, boolean recycleBin) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("note_id", noteId);
        int rows;
        if (!recycleBin) {
            rows = noteMapper.delete(qw);
        } else {
            Note note = new Note();
            note.setUserId(userId);
            note.setNoteId(noteId);
            note.setBinFlag("false");
            note.setLastEditTime(new Date());
            rows = noteMapper.update(note, qw);
        }
        return rows;
    }
}
