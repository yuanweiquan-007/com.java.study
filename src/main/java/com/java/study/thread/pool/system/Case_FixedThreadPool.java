package com.java.study.thread.pool.system;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/23 10:39 上午
 */
@Slf4j
public class Case_FixedThreadPool {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        execute(executorService);
//        submit(executorService);
//        invokeAll(executorService);
        invokeAny(executorService);

        TimeUnit.SECONDS.sleep(2);
        System.exit(0);
    }

    private static void invokeAny(ExecutorService executorService) throws InterruptedException, ExecutionException {
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> {
            Thread.sleep(1000);
            log.info("任务1执行完成");
            return "1";
        });
        callables.add(() -> {
            Thread.sleep(100);
            log.info("任务2执行完成");
            return "2";
        });
        callables.add(() -> {
            Thread.sleep(500);
            log.info("任务3执行完成");
            return "3";
        });

        String any = executorService.invokeAny(callables);
        log.info(any);
    }


    private static void invokeAll(ExecutorService executorService) throws InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(() -> {
            log.info("任务1执行完成");
            return "1";
        });
        callables.add(() -> {
            log.info("任务2执行完成");
            return "2";
        });
        callables.add(() -> {
            log.info("任务3执行完成");
            return "3";
        });

        List<Future<String>> futureList = executorService.invokeAll(callables);
        futureList.forEach(future -> {
            try {
                log.info(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void submit(ExecutorService executorService) throws Exception {
        log.info("执行Callable");
        Future<String> future = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(1);
            return "version";
        });
        log.info("Callable执行结果：{}", future.get());
    }

    private static void execute(ExecutorService executorService) {
        for (int i = 1; i <= 5; i++) {
            int number = i;
            executorService.execute(() -> {
                try {
                    log.info("任务{}执行完成", number);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
    }
}
