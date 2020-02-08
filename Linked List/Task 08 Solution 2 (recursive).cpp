DoublyLinkedListNode* reverse(DoublyLinkedListNode* head) {
    DoublyLinkedListNode* temp = head->next;
    head->next = head->prev;
    head->prev = temp;
    return temp == nullptr ? head : reverse(temp);
}
