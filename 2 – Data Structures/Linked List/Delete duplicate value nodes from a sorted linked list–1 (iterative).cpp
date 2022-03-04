// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem

SinglyLinkedListNode *removeDuplicates(SinglyLinkedListNode *head) {
    SinglyLinkedListNode *traverse = head;
    
    while (traverse && traverse->next) {
        if (traverse->data == traverse->next->data) {
            SinglyLinkedListNode *duplicate = traverse->next;
            traverse->next = duplicate->next;
            delete duplicate;
        } else {
            traverse = traverse->next;
        }
    }
    
    return head;
}
