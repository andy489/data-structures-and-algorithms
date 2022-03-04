// https://www.hackerrank.com/challenges/reverse-a-linked-list/problem

SinglyLinkedListNode *reverse(SinglyLinkedListNode *head) {
    if (!head || !head->next) {
        return head;
    }

    SinglyLinkedListNode *remaining = reverse(head->next);

    head->next->next = head;
    head->next = nullptr;

    return remaining;
}