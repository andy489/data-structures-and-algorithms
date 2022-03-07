// https://leetcode.com/problems/add-two-numbers

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *start = new ListNode(0);
        ListNode *res = start;

        int carry = 0;

        while (l1 || l2) {
            int sum = carry;
            if (l1) {
                sum += l1->val;
                l1 = l1->next;
            }
            if (l2) {
                sum += l2->val;
                l2 = l2->next;
            }

            carry = sum / 10;
            
            start->next = new ListNode(sum % 10);
            start = start->next;
        }
        
        if (carry) {
            start->next = new ListNode(carry);
        }

        return res->next;
    }
};
