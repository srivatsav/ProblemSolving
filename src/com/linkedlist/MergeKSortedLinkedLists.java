package com.linkedlist;

public class MergeKSortedLinkedLists {

  public static void main(String[] args) {
    LinkedList list1 = new LinkedList();
    list1.insertBegin(5);
    list1.insertBegin(4);
    list1.insertBegin(1);

    LinkedList list2 = new LinkedList();
    list2.insertBegin(4);
    list2.insertBegin(3);
    list2.insertBegin(1);

    LinkedList list3 = new LinkedList();
    list3.insertBegin(6);
    list3.insertBegin(2);

    Node[] lists = new Node[] {list1.head, list2.head, list3.head};
    Node result = mergeLinkedLists(lists);

    while (result != null) {
      System.out.print(result.data + "-->");
      result = result.next;
    }
  }

  public static Node mergeLinkedLists(Node[] lists) {

    if (lists == null || lists.length == 0) return null;

    return helper(lists, 0, lists.length - 1);
  }

  public static Node helper(Node[] lists, int left, int right) {
    if (left == right) return lists[left];
    int mid = left + (right - left) / 2;
    Node leftResult = helper(lists, left, mid);
    Node rightResult = helper(lists, mid + 1, right);
    return merge(leftResult, rightResult);
  }

  public static Node merge(Node left, Node right) {
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
