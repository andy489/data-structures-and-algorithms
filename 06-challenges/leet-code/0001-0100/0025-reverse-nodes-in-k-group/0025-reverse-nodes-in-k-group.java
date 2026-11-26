// https://leetcode.com/problems/reverse-nodes-in-k-group/

// Solution: Iterative (Dummy Head) — O(n) time, O(1) space
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (true) {
            ListNode kth = getKth(prev, k);
            if (kth == null) break;

            ListNode nextGroup = kth.next;
            ListNode curr = prev.next;
            ListNode nxt = null;

            while (curr != nextGroup) {
                nxt = curr.next;
                curr.next = kth.next;
                kth.next = curr;
                curr = nxt;
            }

            ListNode tail = prev.next;
            prev.next = kth;
            prev = tail;
        }

        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}

// Solution2: Recursive — O(n) time, O(n/k) space
class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode kth = head;
        int count = 0;
        while (kth != null && count < k) {
            kth = kth.next;
            count++;
        }
        if (count < k) return head;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != kth) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        head.next = reverseKGroup(kth, k);
        return prev;
    }
}
