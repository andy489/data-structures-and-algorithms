// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    SinglyLinkedListNode traverse = head;
    SinglyLinkedListNode prev = null;

    while (traverse != null) {
        SinglyLinkedListNode next = traverse.next;

        traverse.next = prev;
        prev = traverse;
        traverse = next;
    }

    return prev;
}