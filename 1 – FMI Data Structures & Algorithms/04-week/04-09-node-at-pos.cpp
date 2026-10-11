// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem

SinglyLinkedListNode *addAtHead(SinglyLinkedListNode *head, int data) {
    SinglyLinkedListNode *newNode = new SinglyLinkedListNode(data);
    
    if (head == nullptr) {
        head = newNode;
    } else {
        SinglyLinkedListNode *temp = head;
        newNode->next = temp;
        head = newNode;
    }
    
    return head;
}

SinglyLinkedListNode *insertNodeAtPosition(SinglyLinkedListNode *head, int data, int pos) {
    if (pos == 0) {
        return addAtHead(head, data);
    } else {
        SinglyLinkedListNode *newNode = new SinglyLinkedListNode(data);
        SinglyLinkedListNode *traverse = head;
        for (int i = 1; i < pos; ++i) {
            traverse = traverse->next;
        } 
        // traverse points to (pos-1)th Node
        SinglyLinkedListNode *temp = traverse->next; // pos-th Node  :  traverse - newNode - temp
        traverse->next = newNode;
        newNode->next = temp;
    }
    
    return head;
}