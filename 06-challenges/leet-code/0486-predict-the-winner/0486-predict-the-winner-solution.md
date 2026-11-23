# 486. Predict the Winner — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/predict-the-winner/

---

## Solution: DP — O(N²) time, O(N²) space

**Idea:** `dp[i][j]` = max score difference (current player minus other) achievable from subarray `nums[i..j]`. If `dp[0][n-1] >= 0`, player 1 wins.

**Algorithm:**
1. Base: `dp[i][i] = nums[i]`.
2. Fill by increasing length: `dp[i][j] = max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1])`.
3. Return `dp[0][n-1] >= 0`.

**Complexity:**

| | |
|---|---|
| Time | O(N²) |
| Space | O(N²) — DP table |

---

## Solution 2: DP O(N) Space — O(N²) time, O(N) space

**Idea:** Since each row only depends on the previous, use 1D DP.

**Complexity:**

| | |
|---|---|
| Time | O(N²) |
| Space | O(N) |
