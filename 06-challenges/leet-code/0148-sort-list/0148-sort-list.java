// https://leetcode.com/problems/sort-list/

// Solution 1: Top-down merge sort — O(n log n) time, O(log n) space
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(right));
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
            else { curr.next = l2; l2 = l2.next; }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}

// Solution 2: Bottom-up merge sort — O(n log n) time, O(1) space
class Solution2 {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for (ListNode x = head; x != null; x = x.next) n++;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int size = 1; size < n; size <<= 1) {
            ListNode curr = dummy.next, tail = dummy;
            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);
                ListNode[] merged = mergeWithTail(left, right);
                tail.next = merged[0];
                tail = merged[1];
            }
        }
        return dummy.next;
    }

    private ListNode split(ListNode head, int n) {
        for (int i = 1; i < n && head != null; i++) head = head.next;
        if (head == null) return null;
        ListNode rest = head.next;
        head.next = null;
        return rest;
    }

    private ListNode[] mergeWithTail(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
            else { curr.next = l2; l2 = l2.next; }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        while (curr.next != null) curr = curr.next;
        return new ListNode[]{dummy.next, curr};
    }
}
