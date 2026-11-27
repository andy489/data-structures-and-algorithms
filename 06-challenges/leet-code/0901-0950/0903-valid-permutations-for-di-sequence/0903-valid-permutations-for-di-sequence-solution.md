# 903. Valid Permutations for DI Sequence — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/valid-permutations-for-di-sequence/

---

## Solution: DP — O(n²) time, O(n) space

**Idea:** `dp[i][j]` = number of valid permutations of `[0..i]` where the last element placed is the `j`-th smallest remaining. Use prefix sums to transition in O(1).

**Algorithm:**
1. `dp[0] = [1]` (one permutation of length 1, rank 0).
2. For each character: if 'I', `dp[i+1][j] = sum(dp[i][0..j-1])`; if 'D', `dp[i+1][j] = sum(dp[i][j..i])`.
3. Answer is sum of `dp[n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n) |
