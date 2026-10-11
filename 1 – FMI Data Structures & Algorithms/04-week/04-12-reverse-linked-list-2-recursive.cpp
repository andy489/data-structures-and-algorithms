// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

SinglyLinkedListNode *reverse(SinglyLinkedListNode *head) {
    // The tail of the list has been reached which
    // will now be the new head of the reversed list
    if (head == nullptr || head->next == nullptr) {
        return head;
    }

    SinglyLinkedListNode *nextNode = head->next;
    head->next = nullptr;

    SinglyLinkedListNode *newHead = reverse(nextNode);
    // reverse the nodes
    nextNode->next = head;
    
    return newHead;
}
