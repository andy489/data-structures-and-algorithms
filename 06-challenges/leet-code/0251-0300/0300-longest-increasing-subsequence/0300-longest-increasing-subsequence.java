// https://leetcode.com/problems/longest-increasing-subsequence/

// Solution 1: Dynamic Programming — O(n²) time, O(n) space
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

// Solution 2: Binary Search (Patience Sorting) — O(n log n) time, O(n) space
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            int lo = 0, hi = tails.size();
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails.get(mid) < num) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (lo == tails.size()) {
                tails.add(num);
            } else {
                tails.set(lo, num);
            }
        }
        return tails.size();
    }
}
