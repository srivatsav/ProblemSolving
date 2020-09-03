package com.linkedlist;

class ListNode {
  int data;
  ListNode next;
  ListNode bottom;

  ListNode(int data) {
    this.data = data;
    this.next = null;
    this.bottom = null;
  }
}

class LinkedList1 {
  ListNode root;

  public ListNode createList() {
    int arr1[] = new int[] {5, 10, 19, 28};
    int arr2[] = new int[] {7};
    int arr3[] = new int[] {8};
    int arr4[] = new int[] {30};
    int arr5[] = new int[] {20};
    int arr6[] = new int[] {22};
    int arr7[] = new int[] {50};

    ListNode head1 = createList(arr1, arr1.length);
    ListNode head2 = createList(arr2, arr2.length);
    ListNode head3 = createList(arr3, arr3.length);
    ListNode head4 = createList(arr4, arr4.length);
    ListNode head5 = createList(arr5, arr5.length);
    ListNode head6 = createList(arr6, arr6.length);
    ListNode head7 = createList(arr7, arr7.length);

    head1.bottom = head2;
    head2.bottom = head3;
    head3.bottom = head4;
    head1.next.bottom = head5;
    head1.next.next = head6;
    head6.bottom = head7;

    return head1;
  }

  private ListNode createList(int[] arr, int n) {

    ListNode node = null;
    ListNode current = node;

    for (int i = 0; i < n; i++) {
      if (node == null) {
        node = new ListNode(arr[i]);
        current = node;
      } else {
        current.next = new ListNode(arr[i]);
        current = current.next;
      }
    }
    return node;
  }
}

public class FlattenLinkedList {
  public static void main(String[] args) {

    LinkedList1 list = new LinkedList1();
    ListNode head = list.createList();
    flattenList(head);
  }

  private static ListNode flattenList(ListNode root)
  {
    // Your code here
    if(root==null) return root;
    ListNode current = root;
    while(current!=null) {
      if(current.bottom==null) {
        current=current.next;
        continue;
      }
      ListNode temp = current.bottom;
      while(temp.next!=null)
        temp=temp.next;
      temp.next = current.next;
      current.next = temp;
      current.bottom = null;
    }
    return root;
  }
}
