package com.se.schedule.service;

import com.se.schedule.dto.NoteModel;
import com.se.schedule.entity.Note;

import java.util.List;

public interface NoteService {
    /**
     * @return int
     * @author Desmand
     * @Description: 创建记事
     * @Date 6:05 下午 2020/11/28
     * @Param [note]
     */
    public int createNote(Note note);

    /**
     * @return com.se.schedule.entity.Note
     * @author Desmand
     * @Description: 获得记事
     * @Date 6:00 下午 2020/11/28
     * @Param [userId, noteId]
     */
    Note getNote(int userId, int noteId);


    /**
     * @return java.util.List<com.se.schedule.entity.Note>
     * @author Desmand
     * @Description: 获取记事列表
     * @Date 6:01 下午 2020/11/28
     * @Param [userId, tagId, statusFlag]
     */
    List<NoteModel> getNoteList(int userId, int tagId, String statusFlag);

    /**
     * @return int
     * @author Desmand
     * @Description: 修改记事
     * @Date 6:01 下午 2020/11/28
     * @Param [note]
     */
    int updateNote(Note note);

    /**
     * @return int
     * @author Desmand
     * @Description: 删除记事
     * @Date 6:01 下午 2020/11/28
     * @Param [userId, noteId, recycleBin]
     */
    int deleteNote(int userId, int noteId, boolean recycleBin);

}
