package com.linkedlist;

class Node {
  int data;
  Node next;

  Node(){}

  Node(int data) {
    this.data = data;
  }
}

class LinkedList {
  Node head;

  void insertBegin(int data) {
    Node temp = new Node(data);
    temp.next = head;
    head = temp;
  }

  void traverseList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.data + "-->");
      current = current.next;
    }
  }

}

public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertBegin(10);
    linkedList.insertBegin(15);
    linkedList.insertBegin(20);

    linkedList.traverseList();
  }
}