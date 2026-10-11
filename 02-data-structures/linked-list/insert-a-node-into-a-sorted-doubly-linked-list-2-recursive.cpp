// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

DoublyLinkedListNode *sortedInsert(DoublyLinkedListNode *head, int data) {
    DoublyLinkedListNode *insertNode = new DoublyLinkedListNode(data);
    
    if (!head) {
        return insertNode;
    } else if (data <= head->data) {
        insertNode->next = head;
        head->prev = insertNode;
        
        return insertNode;
    } else {
        DoublyLinkedListNode *rest = sortedInsert(head->next, data);
        
        head->next = rest;
        rest->prev = head;
        
        return head;
    }
}


