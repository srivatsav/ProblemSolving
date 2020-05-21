package com.linkedlist;

public class ReverseByKElements {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertBegin(50);
    linkedList.insertBegin(40);
    linkedList.insertBegin(30);
    linkedList.insertBegin(20);
    linkedList.insertBegin(10);

    int k =2;
    linkedList.head = reverseByKElements(linkedList.head, k);
    linkedList.traverseList();
  }

  private static Node reverseByKElements(Node head, int k) {

    if(head==null || head.next==null) return head;

    Node current = head;
    Node prev = null;
    Node next = null;

    int count = 0;
    while (current != null && count < k) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
      count++;
    }

    if(current!=null){
      head.next = reverseByKElements(current, k);
    }
    return prev;
  }
}
