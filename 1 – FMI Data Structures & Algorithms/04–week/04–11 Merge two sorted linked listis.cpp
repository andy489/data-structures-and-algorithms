// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

SinglyLinkedListNode *mergeLists(SinglyLinkedListNode *head1, SinglyLinkedListNode *head2) {
    SinglyLinkedListNode *head3(nullptr);

    if (head1 == nullptr) {
        return (head2);
    }
    
    else if (head2 == nullptr) {
        return (head1);
    }

    if (head1->data <= head2->data) {
        head3 = head1;
        head3->next = mergeLists(head1->next, head2);
    } else {
        head3 = head2;
        head3->next = mergeLists(head1, head2->next);
    }
    
    return head3;
}
