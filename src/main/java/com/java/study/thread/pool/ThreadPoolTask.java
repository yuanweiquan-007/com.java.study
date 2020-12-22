package com.java.study.thread.pool;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 线程池任务
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 11:54 上午
 */
@Data
@AllArgsConstructor
public class ThreadPoolTask {
    private Runnable runnable;
    private String taskName;
}
