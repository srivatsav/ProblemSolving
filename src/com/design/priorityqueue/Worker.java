package com.design.priorityqueue;

public class Worker {

    private final QueueManager queueManager;

    public Worker(QueueManager queueManager) {
        this.queueManager = queueManager;
    }

    public void run() {
        while (true) {
            var message = queueManager.retrieveMessage();
            if (message == null) {
                System.out.println("NO MESSAGE .... WAITING");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(message.message);
            }
        }
    }
}
