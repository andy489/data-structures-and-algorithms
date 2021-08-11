// leetcode.com/problems/merge-k-sorted-lists/
// Time: O(n*log(k))

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class CompareNodes {
public:
    bool operator()(ListNode *l, ListNode *r) {
        return l->val > r->val;
    }
};

class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        ListNode *start = new ListNode(INT_MIN), *res = start;
        
        priority_queue < ListNode * , vector < ListNode * >, CompareNodes > aux;
        
        int k = lists.size();
        for (auto l : lists) if (l) aux.push(l);

        while (!aux.empty()) {
            start->next = aux.top(), aux.pop();
            start = start->next;
            if (start->next) aux.push(start->next);
        }
        return res->next;
    }
};
