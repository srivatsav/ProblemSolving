/** Efficient Solution using slow and fast pointer. */
public class MiddleNode {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertBegin(10);
    linkedList.insertBegin(30);
    linkedList.insertBegin(20);
    linkedList.insertBegin(25);

    Node middleNode = getMiddleNode(linkedList);
    System.out.println("Middle Node :: " + (middleNode == null ? null : middleNode.data));
  }

  static Node getMiddleNode(LinkedList linkedList) {

    Node head = linkedList.head;

    if (head == null) return null;

    if (head.next == null) return head;

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
