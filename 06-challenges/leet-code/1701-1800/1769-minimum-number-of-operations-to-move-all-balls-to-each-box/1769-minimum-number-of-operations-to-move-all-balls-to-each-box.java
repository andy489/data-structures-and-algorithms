// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

// Solution: Two-Pass Prefix/Suffix — O(n) time, O(n) space
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        int balls = 0, ops = 0;
        for (int i = 0; i < n; i++) {
            ans[i] += ops;
            balls += boxes.charAt(i) - '0';
            ops += balls;
        }
        balls = 0;
        ops = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += ops;
            balls += boxes.charAt(i) - '0';
            ops += balls;
        }
        return ans;
    }
}
