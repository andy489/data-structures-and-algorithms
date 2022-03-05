// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem

SinglyLinkedListNode *removeDuplicates(SinglyLinkedListNode *head) {
    if (!head || !head->next) {
        return head;
    }
    
    SinglyLinkedListNode *nextNode = head->next;
    
    while (nextNode && head->data == nextNode->data) {
        SinglyLinkedListNode *duplicate = nextNode;
        nextNode = nextNode->next;
        delete duplicate;
    }
    
    head->next = removeDuplicates(nextNode);
    
    return head;
}
