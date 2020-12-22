package com.java.study.futuretask;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskMain {

     static final ExecutorService executorService = Executors.newFixedThreadPool(4);

     public static void main(String[] args) throws Exception {

          Map<String, Object> result = Maps.newHashMap();
          WarehouseService warehouseService = new WarehouseService();
          LogisitcsService logisitcsService = new LogisitcsService();

          //仓库信息callable
          Callable<Map<String, Object>> warehouseCallable = new Callable<Map<String, Object>>() {
               @Override
               public Map<String, Object> call() throws Exception {
                    return warehouseService.get("27");
               }
          };

          Callable<Map<String, Object>> logisticsCallable = new Callable<Map<String, Object>>() {
               @Override
               public Map<String, Object> call() throws Exception {
                    return logisitcsService.get("EMS");
               }
          };

          FutureTask<Map<String, Object>> warehouseFutureTask = new FutureTask<>(warehouseCallable);
          FutureTask<Map<String, Object>> logisticsFutureTask = new FutureTask<>(logisticsCallable);
          System.out.println("1");
          executorService.submit(warehouseFutureTask);
          executorService.submit(logisticsFutureTask);
          System.out.println("2");
          result.putAll(warehouseFutureTask.get());
          System.out.println("3");
          result.putAll(logisticsFutureTask.get());
          System.out.println("4");
          result.forEach((k, v) -> {
               System.out.println(k + " -> " + v);
          });

          System.exit(0);
     }

}
