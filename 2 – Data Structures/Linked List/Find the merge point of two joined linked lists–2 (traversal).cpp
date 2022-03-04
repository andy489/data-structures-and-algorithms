// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

int getLinkedListSize(SinglyLinkedListNode *head) {
    int s = 0;

    while (head) {
        ++s;
        head = head->next;
    }

    return s;
}

int findMergeNode(SinglyLinkedListNode *head1, SinglyLinkedListNode *head2) {
    int s1 = getLinkedListSize(head1);
    int s2 = getLinkedListSize(head2);

    int traverse = (s1 > s2 ? s1 - s2 : s2 - s1);

    if (s1 < s2) {
        swap(head1, head2);
    }

    while (traverse--) {
        head1 = head1->next;
    }

    while (head1 != head2) {
        head1 = head1->next;
        head2 = head2->next;
    }

    return head1->data;
}
