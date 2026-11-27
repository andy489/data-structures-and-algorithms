# 2110. Number of Smooth Descent Periods of a Stock — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/

---

## Solution: Dynamic Programming / Running Count — O(n) time, O(1) space

**Idea:** For each position `i`, let `dp[i]` be the length of the smooth descent period ending at day `i`. If `prices[i] == prices[i-1] - 1`, then `dp[i] = dp[i-1] + 1`; otherwise `dp[i] = 1`.

The number of smooth descent periods ending at day `i` equals `dp[i]` (since every suffix of a smooth descent run is itself a smooth descent period). The total count is the sum of all `dp[i]`.

**Algorithm:**
1. Initialize `run = 1`, `result = 0`.
2. For each `i` from `0` to `n-1`:
   - If `i > 0` and `prices[i] == prices[i-1] - 1`: `run++`.
   - Else: `run = 1`.
   - Add `run` to `result`.
3. Return `result`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only the running count |
