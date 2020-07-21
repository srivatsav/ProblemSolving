package com.linkedlist;

public class ReverseByRange {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insertBegin(5);
    list.insertBegin(4);
    list.insertBegin(3);
    list.insertBegin(2);
    list.insertBegin(1);

    list.head = reverseBetween(list.head, 2, 4);
    list.traverseList();
  }

  private static Node reverseBetween(Node head, int m, int n) {

    if (head == null || head.next == null)
      return head;

    int idx = 1;

    Node current = head;
    Node prev = null;
    Node next = current.next;

    Node left = null;
    Node right = head;

    while (current != null) {
      if (idx == n)
        break;
      if (idx < m) {
        if (left == null)
          left = head;
        else
          left = left.next;
      }
      if (idx < n)
        right = right.next;

      if (m <= idx && idx <= n)
        current.next = prev;

      prev = current;
      current = next;
      next = current.next;

      idx++;
    }

    Node temp = left.next;
    left.next = prev;
    right.next = temp;
    head = left;
    return head;

  }
}