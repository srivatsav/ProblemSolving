package com.design.priorityqueue;

public class Application {
  public static void main(String[] args) {
    var queueManager = new QueueManager(10);
    // push low priority messages into queue
    for (var i = 0; i < 10; i++)
      queueManager.publishMessage(new Message("Low Priority Message", 0));

    // push high priority messages into queue
    for (var i = 0; i < 10; i++)
      queueManager.publishMessage(new Message("High Priority Message", 1));

    var worker = new Worker(queueManager);
    worker.run();
  }
}
