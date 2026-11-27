# 279. Perfect Squares — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/perfect-squares/

---

## Solution: Dynamic Programming — O(n √n) time, O(n) space

**Idea:** `dp[i]` = minimum number of perfect squares summing to `i`. For each `i`, try all perfect squares `j*j <= i` and take the minimum.

**Algorithm:**
1. `dp[0] = 0`; initialize all others to `∞`.
2. For each `i` from `1` to `n`:
   - For each `j` with `j*j <= i`: `dp[i] = min(dp[i], dp[i - j*j] + 1)`.
3. Return `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n √n) — for each of n values, check up to √n squares |
| Space | O(n) — dp array |
