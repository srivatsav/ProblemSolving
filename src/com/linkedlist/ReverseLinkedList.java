public class ReverseLinkedList {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insertBegin(5);
    list.insertBegin(10);
    list.insertBegin(15);
    list.insertBegin(20);
    list.insertBegin(25);

    // iterativeReverseLinkedList(list);
    // list.traverseList();

    //    list.head = recursiveReverse1LinkedList(list.head);
    //    list.traverseList();

    list.head = recursiveReverse2LinkedList(list.head, null);
    list.traverseList();
  }

  static LinkedList iterativeReverseLinkedList(LinkedList linkedList) {
    Node head = linkedList.head;

    if (head == null) return null;

    Node prev = null;
    Node current = head;
    Node next = current.next;

    while (next != null) {
      current.next = prev;
      prev = current;
      current = next;
      next = current.next;
    }

    current.next = prev;
    linkedList.head = current;

    return linkedList;
  }

  static Node recursiveReverse1LinkedList(Node head) {
    if (head == null || head.next == null) return head;

    Node rest_head = recursiveReverse1LinkedList(head.next);
    Node rest_tail = head.next;

    rest_tail.next = head;
    head.next = null;
    return rest_head;
  }

  static Node recursiveReverse2LinkedList(Node current, Node prev) {
    if (current == null) return prev;
    Node next = current.next;
    current.next = prev;
    return recursiveReverse2LinkedList(next, current);
  }
}
