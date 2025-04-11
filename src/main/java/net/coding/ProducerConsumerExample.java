package main.java.net.coding;

import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumerExample {
    private static final int MAX_SIZE = 5;
    static final Object lock = new Object();
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    produce(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }

    private static void produce(int item) throws InterruptedException {
        synchronized (lock) {
            while (buffer.size() == MAX_SIZE) {
                // 缓冲区已满，生产者线程等待
                lock.wait();
            }
            buffer.add(item);
            System.out.println("Produced: " + item);
            // 唤醒可能正在等待的消费者线程
            lock.notifyAll();

        }
    }

    private static synchronized void consume() throws InterruptedException {
        synchronized (lock) {
            while (buffer.isEmpty()) {
                // 缓冲区为空，消费者线程等待
                lock.wait();
            }
            int item = buffer.poll();
            System.out.println("Consumed: " + item);
            // 唤醒可能正在等待的生产者线程
            lock.notifyAll();

        }
    }
}