// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem

// unordered set
bool has_cycle(SinglyLinkedListNode *head) {
    unordered_set < SinglyLinkedListNode * > set;
    SinglyLinkedListNode *traverseNode = head;
    
    while (traverseNode != nullptr) {
        if (set.count(traverseNode)) {
            return true;
        } else {
            set.insert(traverseNode);
        }
        
        traverseNode = traverseNode->next;
    }
    
    return false;
}
