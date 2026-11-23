# 343. Integer Break — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/integer-break/

---

## Solution: Math (Greedy with 3s) — O(1) time, O(1) space

**Idea:** Breaking into 3s maximizes the product. Split into 3s, handling the remainder: if remainder is 1, use 2+2 instead of 3+1; if 2, keep it.

**Algorithm:**
1. If `n == 2`, return 1. If `n == 3`, return 2.
2. `product = 1`. While `n > 4`: `product *= 3`, `n -= 3`.
3. `product *= n` (remaining 2, 3, or 4 are all better left as-is).
4. Return `product`.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |

---

## Solution 2: DP — O(n^2) time, O(n) space

**Algorithm:**
1. `dp[i]` = max product breaking `i`. `dp[2] = 1`.
2. For each `i` from 3 to n, for each `j` from 1 to `i-1`: `dp[i] = max(dp[i], max(j, dp[j]) * max(i-j, dp[i-j]))`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
