# 1977. Number of Ways to Separate Numbers — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-separate-numbers/

---

## Solution: DP with Prefix Sums and LCP — O(n²) time, O(n²) space

**Idea:** Let `dp[i][j]` = number of valid splits of `num[0..i]` where the last number starts at index `j`. For the transition, the new last number `num[j..i]` must be >= the previous number `num[prev..j-1]`. We use Longest Common Prefix (LCP) precomputation to compare substrings efficiently.

**Algorithm:**
1. Precompute `lcp[i][j]` = length of common prefix of `num[i..]` and `num[j..]`.
2. Use `dp[i][j]` with prefix sums to compute efficiently.
3. Sum all `dp[n-1][j]` for valid `j`.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
