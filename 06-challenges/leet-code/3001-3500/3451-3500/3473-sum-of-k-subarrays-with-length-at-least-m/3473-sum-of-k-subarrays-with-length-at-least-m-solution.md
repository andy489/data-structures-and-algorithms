# 3473. Sum of K Subarrays With Length at Least M — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-k-subarrays-with-length-at-least-m/

---

## Solution: DP with Prefix Sums — O(n * k) time, O(n * k) space

**Idea:** Use DP where dp[i][j] = maximum sum using exactly j non-overlapping subarrays from the first i elements, each of length >= m. Use prefix sums for O(1) subarray sum queries.

**Algorithm:**
1. Compute prefix sums of nums.
2. Define dp[i][j] = max sum using j subarrays from nums[0..i-1].
3. Transition: dp[i][j] = max(dp[i-1][j], max over start s where s <= i-m of dp[s][j-1] + prefix[i] - prefix[s]).
4. Maintain a running max of dp[s][j-1] - prefix[s] to optimize inner loop.
5. Return dp[n][k].

**Complexity:**

| | |
|---|---|
| Time | O(n * k) |
| Space | O(n * k) |
