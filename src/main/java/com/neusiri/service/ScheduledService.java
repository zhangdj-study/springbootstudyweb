package com.neusiri.service;

import org.springframework.stereotype.Service;

/**
 * @author zhangdj
 * @date 2020-07-15 14:24
 */
@Service
public class ScheduledService {

    /**
     * second ,minute, hour, day of month, month, day of week（周几）
     * "0 * * * * MON-FRI"
     */
//    @Scheduled(cron = "0 * * * * MON-FRI")
//    @Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI")
//    @Scheduled(cron = "50-54 * * * * MON-FRI")
//    @Scheduled(cron = "0/4 * * * * MON-FRI")
    public void hello(){
        System.out.println("hello");
    }
}
