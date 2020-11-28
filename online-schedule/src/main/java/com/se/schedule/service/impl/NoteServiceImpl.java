package com.se.schedule.service.impl;

import com.se.schedule.entity.Note;
import com.se.schedule.service.NoteService;

import java.util.List;



public class NoteServiceImpl implements NoteService {
    @Override
    public int createNote(Note note) {

        return 0;
    }

    @Override
    public Note getNote(int userId, int noteId) {
        return null;
    }

    @Override
    public List<Note> getNoteList(int userId, int tagId, String statusFlag) {
        return null;
    }

    @Override
    public int updateNote(Note note) {
        return 0;
    }

    @Override
    public int deleteNote(int userId, int noteId, boolean recycleBin) {
        return 0;
    }
}
