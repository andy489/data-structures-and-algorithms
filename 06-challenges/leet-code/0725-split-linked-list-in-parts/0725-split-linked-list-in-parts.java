// https://leetcode.com/problems/split-linked-list-in-parts/

// Solution: Length Calculation + Split — O(n) time, O(k) space
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        int base = n / k, extra = n % k;
        ListNode[] result = new ListNode[k];
        curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            result[i] = curr;
            int size = base + (i < extra ? 1 : 0);
            for (int j = 1; j < size; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return result;
    }
}
