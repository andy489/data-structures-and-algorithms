# 1639. Number of Ways to Form a Target String Given a Dictionary — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

---

## Solution: DP with Precomputed Column Frequencies — O(L * m) time, O(26 * L + m) space

**Idea:** For each column `k` in the word grid, precompute `cnt[k][c]` = number of words that have character `c` at position `k`. Then use DP where `dp[i]` = number of ways to form `target[0..i-1]` using columns chosen so far.

**Algorithm:**
1. Build `cnt[k][c]` for each column `k` and character `c`.
2. Let `dp[i]` = number of ways to form the first `i` characters of `target`. Initialize `dp[0] = 1`.
3. Iterate columns `k` from `L-1` down to `0` (or forward with a 1D array updated in reverse):
   - For each target index `i` from `m-1` down to `0`:
     - `dp[i+1] += dp[i] * cnt[k][target[i]]`
4. Return `dp[m]`.

**Complexity:**

| | |
|---|---|
| Time | O(L * m) — L columns, m target characters |
| Space | O(26 * L + m) — column frequency table plus DP array |
