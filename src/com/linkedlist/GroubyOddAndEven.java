package com.linkedlist;

public class GroubyOddAndEven {
  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertBegin(5);
    linkedList.insertBegin(4);
    linkedList.insertBegin(3);
    linkedList.insertBegin(2);
    linkedList.insertBegin(1);

    groupByOddAndEven(linkedList.head);
  }

  private static Node groupByOddAndEven(Node head) {
    if (head == null || head.next == null) return head;

    Node result = head;
    Node temp1 = head;
    Node temp2 = head.next;

    while(temp1!=null && temp2!=null)
    {
      if(temp2.next==null) break;

      temp1.next = temp2.next;
      temp1=temp1.next;
    }


    return result;
  }
}
