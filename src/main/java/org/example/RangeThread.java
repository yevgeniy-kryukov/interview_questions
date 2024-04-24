package org.example;

import java.util.List;

public class RangeThread implements Runnable {
    private final List<Integer> range;

    private final Integer targetNum;

    private final static int[] result = new int[2];

    public RangeThread(List<Integer> range, Integer targetNum) {
        this.range = range;
        this.targetNum = targetNum;
    }

    public static int[] getResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        synchronized (result) {
            if (result[0] > 0 && result[1] > 0) {
                return;
            }
        }
        for (int i = 0; i < range.size() - 1; i++) {
            if ((range.get(i) + range.get(i + 1)) == targetNum) {
                synchronized (result) {
                    result[0] = i;
                    result[1] = i + 1;
                    break;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
