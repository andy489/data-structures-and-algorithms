// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/

// Solution: Sort + Sliding Window — O(n log n) time, O(n) space
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.stream(nums).distinct().sorted().toArray();
        int m = sorted.length, res = n, r = 0;
        for (int l = 0; l < m; l++) {
            while (r < m && sorted[r] < sorted[l] + n) { r++; }
            res = Math.min(res, n - (r - l));
        }
        return res;
    }
}
