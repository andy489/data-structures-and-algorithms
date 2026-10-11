// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem

int findMergeNode(SinglyLinkedListNode *head1, SinglyLinkedListNode *head2) {
    SinglyLinkedListNode *t1 = head1;
    SinglyLinkedListNode *t2 = head2;
    
    while (t1 != t2) {
        if (t1->next) {
            t1 = t1->next;
        } else {
            t1 = head2;
        }
        
        if (t2->next) {
            t2 = t2->next;
        } else {
            t2 = head1;
        }
    }
    
    return t1->data;
}

