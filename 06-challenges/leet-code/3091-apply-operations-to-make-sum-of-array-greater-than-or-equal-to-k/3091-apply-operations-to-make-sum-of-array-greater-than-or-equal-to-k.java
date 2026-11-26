// https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

// Solution: Enumerate + Math — O(k) time, O(1) space
class Solution {
    public int minOperations(int k) {
        if (k == 1) { return 0; }
        int ans = k - 1;
        for (int i = 0; i < k; i++) {
            int val = i + 1;
            int j = 0;
            while ((long) val * (1L << j) < k) { j++; }
            ans = Math.min(ans, i + j);
        }
        return ans;
    }
}
