package com.se.schedule.service;

import java.util.List;
import java.util.Map;

public interface SearchService {
    /**
     * @return java.util.List<java.lang.Object>
     * @author Desmand
     * @Description: 搜索关键字
     * @Date 9:58 上午 2020/12/1
     * @Param [keyWord]
     */
    Map<String, List> getSearchKeyWord(String keyWord,int userId);
}
