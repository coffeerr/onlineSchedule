package com.se.schedule.web;

import com.se.schedule.dto.UserModel;
import com.se.schedule.service.SearchService;
import com.se.schedule.util.HttpServletRequestUtil;
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
 * @time: 2020/12/1 10:09 上午
 */
@Controller
@RequestMapping(value = "api", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> searchKeyWord(HttpServletRequest request) {
        String keyword = HttpServletRequestUtil.getString(request, "key");
        int userId = HttpServletRequestUtil.getInt(request,"user_id");
        Map<String, List> returnMap = searchService.getSearchKeyWord(keyword,userId);
        Map<String, Object> map = new HashMap<>();
        if (returnMap.get("schedule_data").size() < 1 && returnMap.get("note_data").size() < 1) {
            map.put("code", "ERROR");
            map.put("message", "获取搜索结果失败");
            map.put("data", -1);
        } else {
            map.put("code", "OK");
            map.put("message", "获取搜索结果成功");
            map.put("data", returnMap);
        }
        return map;
    }
}
