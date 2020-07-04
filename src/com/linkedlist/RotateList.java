package com.linkedlist;

public class RotateList {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    // linkedList.insertBegin(5);
    // linkedList.insertBegin(4);
    linkedList.insertBegin(3);
    linkedList.insertBegin(2);
    linkedList.insertBegin(1);

    linkedList.head = rotateList(linkedList.head, 2000000000);
    linkedList.traverseList();

  }

  private static Node rotateList(Node head, int k) {
    if (head == null)
      return head;

    Node current = head;
    int length = 0;
    while (current != null) {
      current = current.next;
      length++;
    }

    if (length == 1 || k == length)
      return head;

    if (k > length) {
      k = k % length;
    }

    Node left = head;
    current = head;
    Node prev = null;

    int leftCount = 0;
    while (current != null && leftCount < k) {
      prev = current;
      current = current.next;
      leftCount++;
    }

    prev.next = null;
    Node right = current;

    Node leftReverse = reverse(left);
    Node rightReverse = reverse(right);

    if (rightReverse != null) {
      left.next = rightReverse;
      Node rotated = reverse(leftReverse);
      return rotated;
    }
    return leftReverse;

  }

  private static Node reverse(Node head) {
    if (head == null)
      return head;

    Node current = head;
    Node prev = null;
    Node next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
    return prev;
  }
}