// https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

// Solution: Sort by Value, Keep Original Order — O(n log n) time, O(n) space
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) { idx[i] = i; }
        Arrays.sort(idx, (a, b) -> nums[b] - nums[a]);
        int[] chosen = Arrays.copyOf(idx, k);
        Arrays.sort(chosen);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) { res[i] = nums[chosen[i]]; }
        return res;
    }
}
