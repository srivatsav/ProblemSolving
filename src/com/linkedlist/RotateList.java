package com.linkedlist;

public class RotateList {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    // linkedList.insertBegin(5);
    // linkedList.insertBegin(4);
    linkedList.insertBegin(2);
    linkedList.insertBegin(1);
    linkedList.insertBegin(0);

    linkedList.head = rotateList(linkedList.head, 4);
    linkedList.traverseList();

  }

  private static Node rotateList(Node head, int k) {
    if (head == null)
      return head;

    if (k == 0)
      return head;
    int length = 0;
    Node node = head;
    Node lastNode = null;

    while (node != null) {
      length++;
      lastNode = node;
      node = node.next;
    }

    // length = 5
    // node = null
    // lastNode = 5

    if (length == 0)
      return head;

    int position = length - (k % length);
    Node prevNode = null;
    node = head;

    for (int i = 0; i < position; i++) {
      prevNode = node;
      node = node.next;
    }
    //prevNode = 3
    // node = 4
    // lastNode = 5
    // head = 1;

    prevNode.next = null; // 3->null
    lastNode.next = head; // 4->5->1->2->3->null

    head = node;// head->4->5->1->2->3->null
    return head;

  }
}