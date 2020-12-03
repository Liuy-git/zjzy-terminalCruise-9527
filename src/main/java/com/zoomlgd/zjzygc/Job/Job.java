package com.zoomlgd.zjzygc.Job;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ldw
 */
@Component
public class Job {

    // 每天执行一次
    @Scheduled(cron = "0 0 0 * * ?")
    public void job(){
    }
//    @Scheduled(fixedDelay = 60000)
//    public void job2(){
//        System.out.println("我是定时任务 上次执行完成之后一分钟再执行");
//    }
}
