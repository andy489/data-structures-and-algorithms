// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

SinglyLinkedListNode *reverse(SinglyLinkedListNode *head) {
    SinglyLinkedListNode *traverse = head;
    SinglyLinkedListNode *prev = nullptr;
    
    while (traverse != nullptr) {
        SinglyLinkedListNode *next = traverse->next;

        traverse->next = prev;
        prev = traverse;
        traverse = next;
    }
    
    return prev;
}
