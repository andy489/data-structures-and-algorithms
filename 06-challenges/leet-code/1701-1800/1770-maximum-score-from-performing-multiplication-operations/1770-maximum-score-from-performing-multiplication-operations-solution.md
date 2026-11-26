# 1770. Maximum Score from Performing Multiplication Operations — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

---

## Solution: 2D DP (Bottom-Up) — O(m^2) time, O(m^2) space

**Idea:** At each step `i` (0-indexed), if we have taken `l` elements from the left, we have taken `i - l` elements from the right. The right pointer is thus `n - 1 - (i - l)`. The state is `dp[i][l]` = max score after `i` operations with `l` taken from the left. We build it bottom-up from `i = m-1` down to `i = 0`.

**Algorithm:**
1. `dp[i][l]` = best score from operation `i` onward, given `l` left-picks already done.
2. At step `i`, the `l`-th element from left is `nums[l]`, right is `nums[n-1-(i-l)]`.
3. Transition: `dp[i][l] = max(multipliers[i]*nums[l] + dp[i+1][l+1], multipliers[i]*nums[n-1-(i-l)] + dp[i+1][l])`.
4. Answer is `dp[0][0]`.

**Complexity:**

| | |
|---|---|
| Time | O(m^2) — m operations, each with up to m+1 left-pick states |
| Space | O(m^2) — DP table; reducible to O(m) with rolling array |
