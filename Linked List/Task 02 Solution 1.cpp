SinglyLinkedListNode* mergeLists(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    if (!head1) return head2;
    if (!head2) return head1;
    if(head1->data < head2->data)
        head1->next = mergeLists(head1->next, head2);
    else {
        swap(head1,head2);
        head1->next = mergeLists(head1->next, head2);
    }
    return head1;
}
