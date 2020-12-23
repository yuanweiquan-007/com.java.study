package com.java.study.thread.pool.system;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * ThreadPoolExecutor案例
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/23 11:33 上午
 */
@Slf4j
public class Case_ThreadPoolExecutor {

    private static final String module = "Guinean-custom";

    public static void main(String[] args) throws Exception {
        //自定义线程工厂
        CustomThreadFactory threadFactory = new Case_ThreadPoolExecutor().new CustomThreadFactory(module);
        //自定义拒绝策略
        CustomRejectedHandler rejectedHandler = new Case_ThreadPoolExecutor().new CustomRejectedHandler();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,//核心线程数
                2,//最大线程数
                2,//空闲线程存活时间
                TimeUnit.SECONDS,//空闲线程存活时间单位
                new LinkedBlockingQueue<>(2),//任务队列
                threadFactory,//线程工厂
                rejectedHandler)//拒绝策略
                ;

        IntStream.rangeClosed(1, 5).forEach(i -> {
            int number = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    log.info(String.valueOf(number));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        });

        //证明空闲线程(最大线程数大于核心线程数时创建)的存活时间
        for (int i = 0; i <= 5; i++) {
            log.info("线程池中的线程数：{}", executor.getPoolSize());
            TimeUnit.SECONDS.sleep(1);
        }

        System.exit(0);
    }

    class CustomThreadFactory implements ThreadFactory {
        private String module;
        private AtomicInteger number = new AtomicInteger(1);

        public CustomThreadFactory(String module) {
            this.module = module;
        }

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, String.format("%s-%s", module, number.getAndIncrement()));
        }
    }

    /**
     * 拒绝策略
     */
    class CustomRejectedHandler implements RejectedExecutionHandler {
        private Logger logger = LoggerFactory.getLogger(RejectedExecutionHandler.class);
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            logger.info("队列已满，走自定义拒绝策略，丢弃任务");
        }
    }
}
