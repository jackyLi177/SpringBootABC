package com.DesignPattern.single;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args){

        CyclicBarrier barrier = new CyclicBarrier(2);
        for (int i = 1;i<=2;i++){
            new Runner(barrier).start();
        }

    }

    static class Runner extends Thread{
        private CyclicBarrier barrier;

        public Runner(CyclicBarrier barrier){
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "执行完毕");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("执行其他任务**********");
        }
    }

}
