// https://leetcode.com/problems/swap-nodes-in-pairs/

// Solution: Iterative (Dummy Head) — O(n) time, O(1) space
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode dummy(0);
        dummy.next = head;
        ListNode* prev = &dummy;

        while (prev->next && prev->next->next) {
            ListNode* first = prev->next;
            ListNode* second = prev->next->next;

            first->next = second->next;
            second->next = first;
            prev->next = second;

            prev = first;
        }

        return dummy.next;
    }
};

// Solution2: Recursive — O(n) time, O(n) space
class Solution2 {
public:
    ListNode* swapPairs(ListNode* head) {
        if (!head || !head->next) return head;

        ListNode* second = head->next;
        head->next = swapPairs(second->next);
        second->next = head;

        return second;
    }
};
