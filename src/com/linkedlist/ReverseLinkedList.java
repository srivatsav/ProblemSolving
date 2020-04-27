
public class ReverseLinkedList {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.insertBegin(5);
    list.insertBegin(10);
    list.insertBegin(15);
    list.insertBegin(20);
    list.insertBegin(25);

    reverseLinkedList(list);
    list.traverseList();
  }

  static LinkedList reverseLinkedList(LinkedList linkedList) {
    Node head = linkedList.head;

    if (head == null)
      return null;

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
    linkedList.head=current;

    return linkedList;
  }

}