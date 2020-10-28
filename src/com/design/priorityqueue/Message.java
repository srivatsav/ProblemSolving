package com.design.priorityqueue;

public class Message implements Comparable<Message> {

    public final String message;
    private final int priority;

    public Message(String message, int priority) {
        this.message = message;
        this.priority = priority;
    }

    @Override
    public int compareTo(Message message) {
        return this.priority - message.priority;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
