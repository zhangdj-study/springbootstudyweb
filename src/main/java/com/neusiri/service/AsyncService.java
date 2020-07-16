package com.neusiri.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhangdj
 * @date 2020-07-15 14:08
 */
@Service
public class AsyncService {

    @Async
    public void async() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务执行...");
    }
}
