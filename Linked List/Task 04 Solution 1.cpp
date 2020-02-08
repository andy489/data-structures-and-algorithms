SinglyLinkedListNode* insertNodeAtPosition(SinglyLinkedListNode* head, int data, int position) {
    SinglyLinkedListNode* returnNode=head;
    while(--position){
        head=head->next;
    }
    SinglyLinkedListNode* temp=nullptr;
    if(head){
        temp=head->next;
    }
    SinglyLinkedListNode* newNode=new SinglyLinkedListNode(data);
    head->next=newNode;
    if(temp){
        newNode->next=temp;
    }
    return returnNode;
}
