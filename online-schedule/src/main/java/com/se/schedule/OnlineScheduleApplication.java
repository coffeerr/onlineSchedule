package com.se.schedule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.se.schedule.mapper")
public class OnlineScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineScheduleApplication.class, args);
    }

}
