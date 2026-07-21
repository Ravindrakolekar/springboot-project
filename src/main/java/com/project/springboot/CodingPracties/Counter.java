package com.project.springboot.CodingPracties;

class Count{
     int count = 0;

    public synchronized void increment() {
        count++;
    }
}

class Counter {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Thread t1 =  new Thread(() -> {
            for(int i =0;i<10000;i++){
                c.increment();
            }
        });

        Thread t2 =  new Thread(() -> {
            for(int i =0;i<10000;i++){
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);

    }
}