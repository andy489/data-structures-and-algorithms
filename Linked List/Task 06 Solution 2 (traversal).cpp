int getLinkedListSize(SinglyLinkedListNode* head){
  SinglyLinkedListNode* traverse=head;
  int s(0); 
  while (traverse){
    ++s;
    traverse=traverse->next;
  } 
  return s;
}

int findMergeNode(SinglyLinkedListNode *head1, SinglyLinkedListNode *head2){    
    int s1 = getLinkedListSize(head1);
    int s2 = getLinkedListSize(head2);
    int t=s1>s2?s1-s2:s2-s1;
 
    if(s1 < s2){
        swap(head1,head2);       
    }
    while(t--){    
        head1 = head1->next;
    }
    while(head1&&head2){
        if(head1 == head2) return head1->data;
        head1= head1->next;
        head2= head2->next;
    } 
  return -1;         
}
