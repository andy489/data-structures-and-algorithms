// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

// Solution: Bit Shifting — O(n) time, O(1) space
// Solution: Bit Shifting — O(n) time, O(1) space
class Solution {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) | head.val;
            head = head.next;
        }
        return res;
    }
}
