package ru.sberbank.homework.drozdov;

import ru.sberbank.homework.common.tasks.CalculationTask;
import ru.sberbank.homework.common.tasks.SleepyTask;
import ru.sberbank.homework.common.tasks.StringsTask;

public class ParallelThreads {
    public static void main(String[] args) {
        long oneThreadTime = oneThread();
        long multiThreadTime = multiThread();
        System.out.println("All tasks completed in one thread! Time: " + oneThreadTime);
        System.out.println("All tasks completed in multi threads! Time: " + multiThreadTime);
    }
    private static long oneThread(){
        long currentTime = System.currentTimeMillis();
        new StringsTask().run();
        new CalculationTask().run();
        new SleepyTask().run();
        return System.currentTimeMillis() - currentTime;
    }
    private static long multiThread(){
        long currentTime = System.currentTimeMillis();
        Thread stringThread = new Thread(new StringsTask());
        Thread calculateThread = new Thread(new CalculationTask());
        Thread sleepThread = new Thread(new SleepyTask());
        stringThread.start();
        calculateThread.start();
        sleepThread.start();
        try {
            calculateThread.join();
            sleepThread.join();
            stringThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - currentTime;
    }
}
