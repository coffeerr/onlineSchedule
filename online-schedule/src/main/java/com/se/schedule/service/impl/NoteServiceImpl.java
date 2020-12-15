package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.dto.NoteModel;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Schedule;
import com.se.schedule.mapper.NoteMapper;
import com.se.schedule.service.NoteService;
import com.se.schedule.util.StringListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public int createNote(Note note) {
        note.setCreateTime(new Date());
        note.setBinFlag("true");
        QueryWrapper qw = new QueryWrapper();
        qw.eq("note_id", note.getNoteId());
        List<Note> list = noteMapper.selectList(qw);
        if (list.size() > 0) {
            return -1;
        } else {
            int rows = noteMapper.insert(note);
            if (rows > 0) {
                QueryWrapper qw2 = new QueryWrapper();
                qw2.eq("user_id", note.getUserId());
                qw2.eq("note_title", note.getNoteTitle());
                qw2.eq("remarks", note.getRemarks());
                Note note2 = noteMapper.selectOne(qw2);
                return note2.getNoteId();
            } else {
                return -1;
            }
        }

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
    public List<NoteModel> getNoteList(int userId, int tagId, String statusFlag) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        //qw.eq("tag_id", tagId);
        if (statusFlag == null || statusFlag.equals("")) {

        } else if (statusFlag.equals("pin")) {
            qw.eq("pin_flag", "true");
            qw.eq("bin_flag", "true");
        } else if (statusFlag.equals("nopin")) {
            qw.eq("pin_flag", "false");
            qw.eq("bin_flag", "true");
        } else if (statusFlag.equals("delete")) {
            qw.eq("bin_flag", "false");
        }
        List<Note> list = noteMapper.selectList(qw);
        List<NoteModel> noteModels = new ArrayList<>();
        for (Note curNote : list) {
            NoteModel noteModel = new NoteModel();
            noteModel.setNoteId(curNote.getNoteId());
            noteModel.setLastEditTime(curNote.getLastEditTime());
            noteModel.setNoteTitle(curNote.getNoteTitle());
            boolean pinFlag = curNote.getPinFlag().equals("true") ? true : false;
            boolean recycleBin = curNote.getBinFlag().equals("true") ? true : false;
            noteModel.setPinFlag(pinFlag);
            noteModel.setRecycleBin(recycleBin);
            noteModel.setTagId(curNote.getTagId());
            noteModel.setRemarks(curNote.getRemarks());
            noteModel.setTodoItemList(StringListUtil.getTodoItemListByNote(curNote, curNote.getTodoList()));
            noteModel.setUserId(curNote.getUserId());
            noteModels.add(noteModel);
        }
        if (list.size() > 0) {
            return noteModels;
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
            if (rows == 1) {
                return 2;
            } else {
                return -1;
            }
        } else {
            Note note = new Note();
            note.setUserId(userId);
            note.setNoteId(noteId);
            note.setBinFlag("false");
            note.setLastEditTime(new Date());
            rows = noteMapper.update(note, qw);
            if (rows == 1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public int restoreNote(int userId, int noteId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.eq("note_id", noteId);
        Note note = new Note();
        note.setUserId(userId);
        note.setLastEditTime(new Date());
        note.setBinFlag("true");
        note.setNoteId(noteId);
        int rows = noteMapper.update(note, qw);
        return rows;
    }
}
