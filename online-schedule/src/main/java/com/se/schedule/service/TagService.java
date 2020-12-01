package com.se.schedule.service;

import com.se.schedule.entity.Tag;

import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 9:28 上午
 */

public interface TagService {
    /**
     * @return int
     * @author Desmand
     * @Description: 新建标签
     * @Date 9:29 上午 2020/12/1
     * @Param [tag]
     */
    int createTag(Tag tag);

    /**
     * @return java.util.List<com.se.schedule.entity.Tag>
     * @author Desmand
     * @Description: 获取标签列表
     * @Date 9:30 上午 2020/12/1
     * @Param [userId]
     */
    List<Tag> getTagList(int userId);

    /**
     * @return int
     * @author Desmand
     * @Description: 修改标签
     * @Date 9:30 上午 2020/12/1
     * @Param [tag]
     */
    int updateTag(Tag tag);

    /**
     * @return int
     * @author Desmand
     * @Description: 删除标签
     * @Date 9:31 上午 2020/12/1
     * @Param [tag]
     */
    int deleteTag(Tag tag);
}
