package com.ranx.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author ranx
 * @create 2020-01-13 21:47
 **/

@Component
public class ScheduledTask {
    /**
     * @Scheduled(fixedRate = 5000) //上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) //上一次执行完毕时间点之后5秒再执行
     * @Scheduled(cron = "* /5 * * * * * ")  //通过crontab表达式定义规则
     */

    @Scheduled(cron = "0/50 * * * * ? ")
    public void helloSpringBoot() {
        System.out.println("Hello SpringBoot");
    }
}
