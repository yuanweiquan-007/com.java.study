package com.java.study.tool;

import com.java.study.entity.Case_Object;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j
public class Case_Jol {

    static Case_Object case_object = new Case_Object();

    public static void main(String[] args) throws Exception {
        log.info("无hash可偏向");
        log.info(ClassLayout.parseInstance(case_object).toPrintable());

        log.info("有hash不可偏向");
        case_object.hashCode();
        log.info(ClassLayout.parseInstance(case_object).toPrintable());

        log.info("轻量锁");
        synchronized (case_object) {
            log.info(ClassLayout.parseInstance(case_object).toPrintable());
        }

        log.info("线程竞争-重量锁");
        Thread thread = new Thread(() -> syncMethod());
        Thread thread1 = new Thread(() -> syncMethod());
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        log.info(ClassLayout.parseInstance(case_object).toPrintable());
    }

    public static void syncMethod() {
        try {
            synchronized (case_object) {
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
