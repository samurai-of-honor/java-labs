package lab8;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelMonteCarloPi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter threads count: ");
        final int threadsNumber = in.nextInt();

        final int pointsNumber = 1_000_000_0;
        final int pointsByThread = pointsNumber / threadsNumber;

        int[] pointsInCircleByThread = new int[threadsNumber];

//        AtomicInteger iterations = new AtomicInteger(0);
//        AtomicInteger pointsInCircle = new AtomicInteger(0);

        long startTime = System.nanoTime();

        Thread[] threads = new Thread[threadsNumber];
        for (int i = 0; i < threadsNumber; i++) {
            int threadIndex = i;
            Thread thread = new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + " started");

                for (int j = 0; j < pointsByThread; j++) {
                    double x = Math.random();
                    double y = Math.random();

                    if (x * x + y * y <= 1) {
                        pointsInCircleByThread[threadIndex]++;
//                        pointsInCircle.getAndIncrement();
                    }
//                    iterations.getAndIncrement();
                }
//                System.out.println(Thread.currentThread().getName() + " finished");
            });
            threads[i] = thread;
            thread.start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        while (iterations.get() < pointsNumber) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        for (int i = 1; i < threadsNumber; i++) {
            pointsInCircleByThread[0] += pointsInCircleByThread[i];
        }

        double pi = 4.0 * pointsInCircleByThread[0] / pointsNumber;
        long executionTime = System.nanoTime() - startTime;

        System.out.printf("PI = %f\nTHREADS = %d\nITERATION = %d\nTIME = %dms",
                pi, threadsNumber, pointsNumber, executionTime / 1_000_000);
    }
}