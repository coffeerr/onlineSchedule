package com.se.schedule.util;

import com.se.schedule.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 9:21 下午
 */

public class StringUtil {
    /**
     * @return java.util.List<java.lang.String>
     * @author Desmand
     * @Description: 清单分割
     * @Date 9:23 下午 2020/11/29
     * @Param [s]
     */
    static List<String> getTodoNameList(String s) {
        List<String> list = new ArrayList<>();
        String[] strs = s.split("#");
        for (String i : strs) {
            list.add(i);
        }
        return list;
    }
}
