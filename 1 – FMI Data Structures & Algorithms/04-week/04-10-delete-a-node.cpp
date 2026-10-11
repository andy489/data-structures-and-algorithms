// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem

SinglyLinkedListNode *deleteNode(SinglyLinkedListNode *head, int position) {

    if (position == 0) {
        SinglyLinkedListNode *temp = head->next;
        delete head;
        head = temp;
    } else {
        SinglyLinkedListNode *traverse = head;

        for (int i = 0; i < position - 1; i++) {
            traverse = traverse->next;
        }
        // traverseNode points to (pos-1)th Node
        SinglyLinkedListNode *temp = traverse->next; // pos-th Node (node we want to remove)
        traverse->next = temp->next; // (pos+1)th Node
        delete temp; // remove temp;
    }
    
    return head;
}
