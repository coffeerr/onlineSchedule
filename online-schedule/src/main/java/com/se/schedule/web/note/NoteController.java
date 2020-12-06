package com.se.schedule.web.note;

import com.se.schedule.dto.NoteModel;
import com.se.schedule.entity.Note;
import com.se.schedule.entity.Schedule;
import com.se.schedule.service.NoteService;
import com.se.schedule.util.HttpServletRequestUtil;
import com.se.schedule.util.StringListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 7:46 下午
 */
@Controller
@RequestMapping(value = "api")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/note", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createNote(@RequestBody Note note) {
        Map<String, Object> map = new HashMap<>();
        int rows = noteService.createNote(note);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "新建记事成功");
            map.put("data", rows);
        } else {
            map.put("code", "ERROR");
            map.put("message", "新建记事失败");
            map.put("data", rows);
        }
        return map;
    }


    @RequestMapping(value = "/note", method = RequestMethod.GET, params = "user_id")
    @ResponseBody
    public Map<String, Object> getNote(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int userId = HttpServletRequestUtil.getInt(request, "user_id");
        int noteId = HttpServletRequestUtil.getInt(request, "note_id");
        Note curNote = noteService.getNote(userId, noteId);
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
        if (curNote != null) {
            map.put("code", "OK");
            map.put("message", "获取记事成功");
            map.put("data", noteModel);
        } else {
            map.put("code", "ERROR");
            map.put("message", "获取记事失败");
            map.put("data", "rows");
        }
        return map;
    }

    @RequestMapping(value = "/note/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getNoteList(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        int userId = HttpServletRequestUtil.getInt(request, "user_id");
        int tagId = HttpServletRequestUtil.getInt(request, "tag_id");
        String status_flag = HttpServletRequestUtil.getString(request, "status_flag");
        List<NoteModel> list = noteService.getNoteList(userId, tagId, status_flag);

        if (list.size() > 0) {
            map.put("code", "OK");
            map.put("message", "获取记事列表成功");
            map.put("data", list);
        } else {
            map.put("code", "ERROR");
            map.put("message", "获取记事列表失败");
            map.put("data", "-1");
        }
        return map;
    }

    @RequestMapping(value = "/note", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateNote(@RequestBody Note note) {
        Map<String, Object> map = new HashMap<>();
        int rows = noteService.updateNote(note);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "修改记事成功");
            map.put("data", note.getNoteId());
        } else {
            map.put("code", "ERROR");
            map.put("message", "修改记事失败");
            map.put("data", "-1");
        }
        return map;
    }

    @RequestMapping(value = "/note", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> daleteNote(@RequestBody NoteModel noteModel) {
        Map<String, Object> map = new HashMap<>();
        Note note = new Note();
        note.setUserId(noteModel.getUserId());
        note.setNoteId(noteModel.getNoteId());
        boolean recycleBin = noteModel.isRecycleBin();
        int rows = noteService.deleteNote(noteModel.getUserId(), noteModel.getNoteId(), recycleBin);
        if (rows > 0) {
            map.put("code", "OK");
            map.put("message", "删除记事成功");
            map.put("data", rows);
        } else {
            map.put("code", "ERROR");
            map.put("message", "删除记事失败");
            map.put("data", "-1");
        }
        return map;
    }


}
