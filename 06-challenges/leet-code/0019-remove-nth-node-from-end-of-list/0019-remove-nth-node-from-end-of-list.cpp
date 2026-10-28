// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// Solution 1: Two Pointers (One Pass) — O(n) time, O(1) space
class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        ListNode dummy(0, head);
        ListNode *slow = &dummy, *fast = &dummy;

        for (int i = 0; i <= n; i++) {   // gap of n+1 so slow lands before the target
            fast = fast->next;
        }

        while (fast) {                   // advance together until fast falls off
            slow = slow->next;
            fast = fast->next;
        }

        slow->next = slow->next->next;   // unlink the nth-from-end node
        return dummy.next;
    }
};

// Solution 2: Recursive — O(n) time, O(n) space
class Solution2 {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        ListNode dummy(0, head);
        dfs(&dummy, n);
        return dummy.next;
    }

private:
    // returns depth from end; removes the node when depth == n
    int dfs(ListNode *node, int n) {
        if (!node->next) {
            return 0;                              // base: tail is depth 0 from end
        }

        int depth = dfs(node->next, n) + 1;       // depth of node->next from end, +1 for this edge

        if (depth == n) {
            node->next = node->next->next;         // skip the target node
        }

        return depth;
    }
};
