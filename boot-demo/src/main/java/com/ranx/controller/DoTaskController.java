
package com.ranx.controller;

import com.ranx.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author ranx
 * @create 2018-04-22 22:54
 **/
@RestController
@RequestMapping("tasks")
public class DoTaskController {
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("task")
    public String test1() throws Exception {
        long start = System.currentTimeMillis();

        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();

        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        String times = "任务全部完成，总耗时： " + (end -start) + "毫秒";
        System.out.println(times);

        return times;
    }
}