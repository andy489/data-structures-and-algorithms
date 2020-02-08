DoublyLinkedListNode* reverse(DoublyLinkedListNode* head) {
        DoublyLinkedListNode*traverse=head;        
        DoublyLinkedListNode*newHead=head;        
        while(traverse){
            DoublyLinkedListNode* prev=traverse->prev;
            traverse->prev=traverse->next;
            traverse->next=prev;
            newHead=traverse;
            traverse=traverse->prev;            
        }
        return newHead;
}
