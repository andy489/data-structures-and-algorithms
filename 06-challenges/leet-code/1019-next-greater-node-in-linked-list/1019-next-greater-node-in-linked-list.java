// https://leetcode.com/problems/next-greater-node-in-linked-list/

// Solution: Monotonic Stack — O(n) time, O(n) space
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            vals.add(cur.val);
        }
        int n = vals.size();
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && vals.get(stack.peek()) < vals.get(i)) {
                ans[stack.pop()] = vals.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}
