// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

// Solution: Prefix Sum HashMap (Two-Pass) — O(n) time, O(n) space
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> prefixMap = new HashMap<>();
        int prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            prefixMap.put(prefix, node);
        }
        prefix = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            prefix += node.val;
            node.next = prefixMap.get(prefix).next;
        }
        return dummy.next;
    }
}
