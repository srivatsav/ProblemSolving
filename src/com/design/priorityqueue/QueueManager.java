package com.design.priorityqueue;

public class QueueManager {

    private final PriorityMessageQueue<Message> priorityQueue;

    public QueueManager(int initCapacity) {
        priorityQueue = new PriorityMessageQueue<>(new Message[initCapacity]);
    }

    public void publishMessage(Message message) {
        priorityQueue.push(message);
    }

    public Message retrieveMessage() {
        if (priorityQueue.isEmpty())
            return null;
        return priorityQueue.remove();
    }
}
