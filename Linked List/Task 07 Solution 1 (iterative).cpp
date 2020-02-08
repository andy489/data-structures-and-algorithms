DoublyLinkedListNode* sortedInsert(DoublyLinkedListNode* head, int data){
    DoublyLinkedListNode* insertNode=new DoublyLinkedListNode(data);
    if(!head) return insertNode;
    else if(head->data>data){
        DoublyLinkedListNode* temp=head;
        head=insertNode;
        insertNode->next=temp;
        temp->prev=insertNode;
    }
    else{
        DoublyLinkedListNode* traverseNode=head;
        while(traverseNode!=nullptr&&traverseNode->data<data){
            
        }
    }
}

