# 3366. Minimum Array Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-array-sum/

---

## Solution: 2D Dynamic Programming — O(n · op1 · op2) time, O(op1 · op2) space

**Idea:** Let `dp[i][j]` = minimum achievable sum considering all elements processed so far, having used exactly `i` op1 uses and `j` op2 uses. For each element we decide: skip it, apply only op1, apply only op2 (if feasible), or apply both in either order (op1 then op2, or op2 then op1) — taking the minimum of all valid choices.

**Algorithm:**
1. Initialise `dp[0][0] = 0`; all other cells at `+∞`.
2. For each `x` in `nums`:
   - For each state `(i, j)` with `dp[i][j] < ∞`:
     - **No op**: `dp[i][j] += x`
     - **Op1 only** (if `i < op1`): `dp[i+1][j] = min(..., dp[i][j] + ceil(x/2))`
     - **Op2 only** (if `j < op2` and `x >= k`): `dp[i][j+1] = min(..., dp[i][j] + x - k)`
     - **Op1 then Op2** (if `i < op1` and `j < op2` and `ceil(x/2) >= k`): `dp[i+1][j+1] = min(..., dp[i][j] + ceil(x/2) - k)`
     - **Op2 then Op1** (if `i < op1` and `j < op2` and `x >= k`): `dp[i+1][j+1] = min(..., dp[i][j] + ceil((x-k)/2))`
3. Answer is `min over all i, j of dp[i][j]`.

We process updates on a **copy** of the DP table to avoid reusing ops on the same element.

**Complexity:**

| | |
|---|---|
| Time | O(n · op1 · op2) — n ≤ 100, op1/op2 ≤ 100, so at most 10^6 states |
| Space | O(op1 · op2) — only the current DP table |
