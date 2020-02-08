int findMergeNode(SinglyLinkedListNode* head1, SinglyLinkedListNode* head2) {
    unordered_set<SinglyLinkedListNode*>set;
    while(head1){
        set.insert(head1);
        head1=head1->next;        
    }
    while(true){
        if(set.count(head2)){
            return head2->data;
        }
        head2=head2->next;        
    }
}
