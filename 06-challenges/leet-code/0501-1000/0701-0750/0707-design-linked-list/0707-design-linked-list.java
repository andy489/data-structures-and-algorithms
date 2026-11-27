// https://leetcode.com/problems/design-linked-list/

// Solution: Singly Linked List with Sentinel Head — O(n) indexed, O(1) head/tail
class MyLinkedList {
    private static class Node {
        int val;
        Node next;
        Node(int val) { this.val = val; }
    }

    private final Node dummy;
    private Node tail;
    private int size;

    public MyLinkedList() {
        dummy = new Node(0);
        tail = dummy;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node curr = dummy.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = dummy.next;
        dummy.next = node;
        if (size == 0) {
            tail = node;
        }
        size++;
    }

    public void addAtTail(int val) {
        tail.next = new Node(val);
        tail = tail.next;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(val);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node prev = dummy;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        if (prev.next == tail) {
            tail = prev;
        }
        prev.next = prev.next.next;
        size--;
    }
}
