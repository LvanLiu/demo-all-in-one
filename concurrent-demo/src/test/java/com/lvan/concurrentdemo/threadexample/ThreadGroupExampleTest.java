package com.lvan.concurrentdemo.threadexample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Lvan
 * @since 2021/11/20
 */
@Slf4j
class ThreadGroupExampleTest {

    @Test
    void createGroup() {

        //父线程组
        ThreadGroup parentThreadGroup = Thread.currentThread().getThreadGroup();
        log.info("parent thread group name:{}", parentThreadGroup.getName());

        ThreadGroup threadGroup1 = new ThreadGroup("group1");
        log.info("current thread group is main thread group:{}", threadGroup1.getParent().getName().equals(parentThreadGroup.getName()));
    }

    @Test
    void enumerateThreadTest() throws Exception {

        //创建线程组
        ThreadGroup threadGroup = new ThreadGroup("myGrpup");

        //创建线程，并加入到线程组
        Thread thread = new Thread(threadGroup, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "myThread");
        thread.start();

        TimeUnit.MICROSECONDS.sleep(2);
        ThreadGroup parentThreadGroup = Thread.currentThread().getThreadGroup();

        Thread[] threads = new Thread[parentThreadGroup.activeCount()];
        int size = parentThreadGroup.enumerate(threads);

        log.info("enumerate size:{}", size);
        for (Thread t : threads) {
            log.info(t.getName());
        }

        Thread[] threads2 = new Thread[parentThreadGroup.activeCount()];
        int size2 = parentThreadGroup.enumerate(threads2, false);

        log.info("enumerate size:{}", size2);
        for (Thread t : threads2) {
            log.info(t.getName());
        }
    }

    @Test
    void enumerateThreadGroupTest() throws Exception {

        ThreadGroup group1 = new ThreadGroup("g1");
        ThreadGroup group2 = new ThreadGroup(group1, "g2");

        TimeUnit.MICROSECONDS.sleep(2);

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup[] threadGroups = new ThreadGroup[mainThreadGroup.activeCount()];
        int size = mainThreadGroup.enumerate(threadGroups);
        log.info("enumerate group size:{}", size);

        ThreadGroup[] threadGroups1 = new ThreadGroup[mainThreadGroup.activeCount()];
        int size1 = mainThreadGroup.enumerate(threadGroups1, false);
        log.info("enumerate group size:{}", size1);
    }

    @Test
    void interruptTest() throws Exception {

        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
        new Thread(threadGroup, () -> {
            while (true) {
                try {
                    TimeUnit.MICROSECONDS.sleep(2);
                } catch (InterruptedException ex) {
                    break;
                }
                log.info("t1 it will exit");
            }
        }, "t1").start();

        new Thread(threadGroup, () -> {
            while (true) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    break;
                }
                log.info("t2 it will exit");
            }
        }, "t2").start();

        TimeUnit.MICROSECONDS.sleep(2);

        threadGroup.interrupt();
        log.info("end");
    }
}