// https://leetcode.com/problems/add-two-numbers-ii/

// Solution: Two Stacks — O(m+n) time, O(m+n) space
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        for (ListNode node = l1; node != null; node = node.next) {
            stack1.push(node.val);
        }
        for (ListNode node = l2; node != null; node = node.next) {
            stack2.push(node.val);
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
