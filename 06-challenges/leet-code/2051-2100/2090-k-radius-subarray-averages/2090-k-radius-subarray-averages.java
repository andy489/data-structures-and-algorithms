// https://leetcode.com/problems/k-radius-subarray-averages/

// Solution: Sliding Window — O(n) time, O(n) space
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (2 * k + 1 > n) { return res; }
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) { prefix[i + 1] = prefix[i] + nums[i]; }
        int diameter = 2 * k + 1;
        for (int i = k; i < n - k; i++) { res[i] = (int)((prefix[i + k + 1] - prefix[i - k]) / diameter); }
        return res;
    }
}
