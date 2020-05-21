package com.linkedlist;

public class NthNodeFromEnd {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insertBegin(5);
    list.insertBegin(10);
    list.insertBegin(15);
    list.insertBegin(20);
    list.insertBegin(25);

    int n = 5;
    Node nthNodeFromEnd = findNthNodeFromEnd(n, list);
    System.out.println("Nth Node From End :: " + (nthNodeFromEnd != null ? nthNodeFromEnd.data : null));

  }

  static Node findNthNodeFromEnd(int n, LinkedList linkedList) {
    Node head = linkedList.head;

    if (head == null)
      return null;

    Node slow = head;
    Node fast = head;

    while (n > 0) {
      if (fast == null)
        return null;
      fast = fast.next;
      n--;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}