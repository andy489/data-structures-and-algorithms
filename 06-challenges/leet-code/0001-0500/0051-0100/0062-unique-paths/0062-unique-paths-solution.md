# 62. Unique Paths — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-paths/

---

## Solution: DP (1D Space-Optimized) — O(m·n) time, O(n) space

**Idea:** `dp[j]` = number of ways to reach column `j` in the current row. Each cell equals the sum of the cell above (same `dp[j]`) and the cell to the left (`dp[j-1]`). Initialize all `dp[j] = 1` (single-row base case), then update row by row.

**Algorithm:**
1. Initialize `dp = [1, 1, ..., 1]` of length `n`.
2. For each row `i` from `1` to `m-1`, for each column `j` from `1` to `n-1`: `dp[j] += dp[j-1]`.
3. Return `dp[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — fill every cell once |
| Space | O(n) — single row |

---

## Solution 2: Combinatorics — O(min(m,n)) time, O(1) space

**Idea:** The robot makes exactly `m-1` down and `n-1` right moves. The number of unique paths is the number of ways to choose which `m-1` of the `m+n-2` total moves are "down": `C(m+n-2, m-1)`.

**Algorithm:**
1. Compute `C(m+n-2, min(m,n)-1)` using a running product to avoid overflow:
   - Numerator: `(m+n-2) * (m+n-3) * ... * (m+n-2 - k + 1)` where `k = min(m,n)-1`
   - Divide by `k!` incrementally: `result = result * (m+n-2-i) / (i+1)` for `i` from `0` to `k-1`.

**Complexity:**

| | |
|---|---|
| Time | O(min(m,n)) — k multiplications |
| Space | O(1) — single variable |
