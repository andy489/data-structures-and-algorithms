// https://leetcode.com/problems/reorder-list/

// Solution 1: Find Middle + Reverse + Merge — O(n) time, O(1) space
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);

        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }
}

// Solution 2: Deque — O(n) time, O(n) space
class Solution2 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            dq.addLast(cur);
            cur = cur.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        boolean front = true;
        while (!dq.isEmpty()) {
            tail.next = front ? dq.pollFirst() : dq.pollLast();
            tail = tail.next;
            front = !front;
        }
        tail.next = null;
    }
}
