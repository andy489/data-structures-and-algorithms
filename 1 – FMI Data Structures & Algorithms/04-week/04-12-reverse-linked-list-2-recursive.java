// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
    if (head == null || head.next == null) {
        return head;
    }

    SinglyLinkedListNode remaining = reverse(head.next);

    head.next.next = head;
    head.next = null;

    return remaining;
}