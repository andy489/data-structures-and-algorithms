// https://leetcode.com/problems/max-value-of-equation/

// Solution: Monotonic Deque — O(n) time, O(n) space
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int[] p : points) {
            int x = p[0], y = p[1];
            while (!dq.isEmpty() && x - dq.peekFirst()[0] > k) dq.pollFirst();
            if (!dq.isEmpty()) ans = Math.max(ans, y + x + dq.peekFirst()[1] - dq.peekFirst()[0]);
            while (!dq.isEmpty() && dq.peekLast()[1] - dq.peekLast()[0] <= y - x) dq.pollLast();
            dq.offerLast(p);
        }
        return ans;
    }
}
