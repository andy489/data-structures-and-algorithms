// https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/

// Solution: Difference Array + Sort — O(n log n) time, O(n) space
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int MOD = 1_000_000_007;
        int[] freq = new int[n + 1];
        for (int[] req : requests) {
            freq[req[0]]++;
            freq[req[1] + 1]--;
        }
        // Prefix sum to get request frequency for each index
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(freq, 0, n);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result = (result + (long) nums[i] * freq[i]) % MOD;
        }
        return (int) result;
    }
}
