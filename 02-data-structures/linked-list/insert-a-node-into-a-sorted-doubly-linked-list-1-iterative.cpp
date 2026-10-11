// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem

DoublyLinkedListNode *sortedInsert(DoublyLinkedListNode *head, int data) {
    DoublyLinkedListNode *insertNode = new DoublyLinkedListNode(data);

    if (!head) {
        return insertNode;
    } else if (head->data > data) {
        DoublyLinkedListNode *temp = head;
    } else {
        DoublyLinkedListNode *traverseNode = head;
        while (traverseNode != nullptr && traverseNode->data < data) {

        }
    }

    head = insertNode;
    insertNode->next = temp;
    temp->prev = insertNode;
    
    return head;
}




