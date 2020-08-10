// github.com/andy489

// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

SinglyLinkedListNode* reverse(SinglyLinkedListNode *head){
    // The tail of the list has been reached which
    // will now be the new head of the reversed list
    if (head == NULL || head->next == NULL)
        return head;

    SinglyLinkedListNode* nextNode = head->next;
    head->next = NULL;
    SinglyLinkedListNode* newHead = reverse(nextNode);
    // reverse the nodes
    nextNode->next = head;
    return newHead;
}
