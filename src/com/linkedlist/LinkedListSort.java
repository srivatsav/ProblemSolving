package com.linkedlist;

public class LinkedListSort {

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();
    linkedList.insertBegin(1);// f
    linkedList.insertBegin(2);
    linkedList.insertBegin(3);
    linkedList.insertBegin(4);
    linkedList.insertBegin(5);// s

    // f
    linkedList.insertBegin(6);
    linkedList.insertBegin(7);// s

    //f
    linkedList.insertBegin(8);
    linkedList.insertBegin(9);//s f


    Node res = sortLinkedList(linkedList.head);

    while (res != null) {
      System.out.print(res.data + "-->");
      res = res.next;
    }
  }

  public static Node sortLinkedList(Node head) {
    if (head == null || head.next == null) return head;

    Node slowPointer = head;
    Node fastPointer = head;
    Node tail = null;

    while (fastPointer.next != null) {
      tail = slowPointer;
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
      if (fastPointer == null) break;
    }

    tail.next = null;

    Node leftHalf = sortLinkedList(head);
    Node rightHalf = sortLinkedList(slowPointer);

    return merge(leftHalf, rightHalf);
  }

  static Node merge(Node left, Node right) {
    if (left == null) return right;
    if (right == null) return left;

    Node head = null;
    if (left.data < right.data) {
      head = left;
      head.next = merge(left.next, right);
    } else {
      head = right;
      head.next = merge(left, right.next);
    }

    return head;
  }
}
