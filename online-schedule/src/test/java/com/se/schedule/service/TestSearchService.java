package com.se.schedule.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 10:05 上午
 */
@SpringBootTest
public class TestSearchService {
    @Autowired
    SearchService searchService;
    @Test
    public void testSearch(){
        //List<Object> list= searchService.getSearchKeyWord("#");
       // System.out.println(list.toString());
    }
}
