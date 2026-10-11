// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem

int getNode(SinglyLinkedListNode *head, int positionFromTail) {
    int index = 0;
    
    SinglyLinkedListNode *current = head;
    SinglyLinkedListNode *result = head;

    while (current != nullptr) {
        current = current->next;

        if (index++ > positionFromTail) {
            result = result->next;
        }
    }

    return result->data;
}
