// https://hackerrank-challenge-pdfs.s3.amazonaws.com/1088-insert-a-node-at-a-specific-position-in-a-linked-list-English?AWSAccessKeyId=AKIAR6O7GJNX5DNFO3PV&Expires=1646137330&Signature=8h3JHo0ojla1Xs7NFS%2BOXt9tZks%3D&response-content-disposition=inline%3B%20filename%3Dinsert-a-node-at-a-specific-position-in-a-linked-list-English.pdf&response-content-type=application%2Fpdf

SinglyLinkedListNode* insertNodeAtPosition(SinglyLinkedListNode* head, int data, int position) {
    SinglyLinkedListNode* returnNode = head;
    
    while(--position){
        head = head->next;
    }

    SinglyLinkedListNode* temp = nullptr;

    if(head){
        temp = head->next;
    }

    SinglyLinkedListNode* newNode = new SinglyLinkedListNode(data);
    head->next = newNode;
   
    if(temp){
        newNode->next = temp;
    }

    return returnNode;
}
