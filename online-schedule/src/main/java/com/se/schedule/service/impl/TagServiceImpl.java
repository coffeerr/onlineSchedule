package com.se.schedule.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.se.schedule.entity.Tag;
import com.se.schedule.mapper.TagMapper;
import com.se.schedule.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 9:31 上午
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagMapper tagMapper;

    @Override
    public int createTag(Tag tag) {
        int rows = tagMapper.insert(tag);
        if (rows > 0) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("user_id", tag.getUserId());
            qw.eq("tag_title", tag.getTagTitle());
            List<Tag> list = tagMapper.selectList(qw);
            if(list.size()>0){
                return -2;
            }
            Tag returnTag = tagMapper.selectOne(qw);
            return tag.getTagId();
        } else {
            return -1;
        }
    }

    @Override
    public List<Tag> getTagList(int userId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        List<Tag> list = tagMapper.selectList(qw);
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int updateTag(Tag tag) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("tag_id", tag.getTagId());
        int rows = tagMapper.update(tag, qw);
        if (rows > 0) {
            return rows;
        } else {
            return -1;
        }
    }

    @Override
    public int deleteTag(Tag tag) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("tag_id", tag.getTagId());
        int rows = tagMapper.delete(qw);
        if (rows > 0) {
            return rows;
        } else {
            return -1;
        }
    }
}
